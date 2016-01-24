package com.hackbulgaria.corejava.crawler.no;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ParalelWebCrawler {
	private final Set<URI> visitedUrls = new AtomicSet();
	private ExecutorService service;

	public ParalelWebCrawler(ExecutorService service) {
		this.service = service;
	}

	public Set<URI> crawl(URI currentLocation, final String needle, AtomicInteger parentInt) throws URISyntaxException, MalformedURLException, InterruptedException, ExecutionException { 
		Set<URI> finalResult = Collections.synchronizedSet(new HashSet<URI>());
//		visitedUrls.add(currentLocation);
		String urlContents = downloadContents(currentLocation);
		if (urlContents.contains(needle)) {
			// return
			finalResult.add(currentLocation);
			System.out.println("found in " + currentLocation);
		}
		{
			Set<String> allLinks = getAllLinks(urlContents);
			removeNotNeededLinks(allLinks);
			
			AtomicInteger i = new AtomicInteger();
			List<URI> filterURIs = filterURIs(currentLocation, allLinks);
			List<Future<Set<URI>>> futures = new ArrayList<Future<Set<URI>>>();
			for (URI link : filterURIs) {
				if (!visitedUrls.contains(link)) { // visitedUrls.add(currentLocation);
					i.incrementAndGet();
					futures.add(service.submit( () -> {
						Set<URI> crawl = crawl(link, needle, i);
						i.decrementAndGet();
						// parent notify
						synchronized (i) {
							i.notify();
						}
						return crawl;
					}));
				}
			}
			

			// while children not finished - wait
			// don't wait if children not started
			while (!i.compareAndSet(0, 0)) {
				synchronized (i) {
					i.wait();
				}
			}
			
			for (Future<Set<URI>> resultFuture : futures) {
				Set<URI> result = resultFuture.get();
				if (!result.isEmpty()) {
					finalResult.addAll(result);
				}
			}
		}
		return finalResult;
	}

	private List<URI> filterURIs(URI currentLocation, Set<String> allLinks) {
		List<? extends Object> filteredLinks = allLinks.stream().map(
				link -> {
					try {
						return normalizeLink(currentLocation, link);
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
				})
				.filter(link -> {
					return link != null;
				})
				.filter(url -> {
					try {
						return isInsideDomain(currentLocation, (URI)url);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				}) 
				.collect(Collectors.toList());
		
		List<URI> res = new ArrayList<URI>();
		for (Object uri : filteredLinks) {
			res.add((URI)uri);
		}
		return res;
	}
	
	private void removeNotNeededLinks(Set<String> allLinks) {
		if (allLinks.contains("#")) {
			allLinks.remove("#");
		}
	}

	private static boolean isInsideDomain(URI currentLocation, URI asUrl)
			throws URISyntaxException {
		return currentLocation.getHost().equals(asUrl.getHost());
	}

	private URI normalizeLink(URI currentLocation, String link)
			throws MalformedURLException, URISyntaxException {
		URI uri = null;
		try {
			uri = new URI(link);
		} catch (URISyntaxException e) {
			System.out.println(e);
			return null;
		}
		
		if (uri.getScheme() != null && uri.getHost() != null) {
			return uri;
		}
		return URIUtils.resolve(currentLocation, uri);
	}

	private static String downloadContents(URI startLocation)
			throws URISyntaxException {
		HttpClient httpClient = new DefaultHttpClient();
		System.out.println("Currently crawling : " + startLocation);
		HttpGet get = new HttpGet(startLocation);
		try {
			HttpResponse response = httpClient.execute(get);
			String contents = EntityUtils.toString(response.getEntity(),
					StandardCharsets.UTF_8);
			return contents;
		} catch (IOException e) {
			e.printStackTrace();
			// IO Error when connecting to the server, whatever, just return
			// empty contents
			return "";
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	private static Set<String> getAllLinks(String content) {
		Set<String> resultList = new HashSet<>();
		// ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}
	
	private boolean testSharp(Set<URI> visitedUrls, URI uri) {
		boolean result = true;
		String url = uri.toString();
		if (url.endsWith("#")) {
			url = url.substring(0, url.length() - 1);
			try {
				if (visitedUrls.contains(new URI(url))) {
					result = false;
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result && url.endsWith("/")) {
				url = url.substring(0, url.length() - 1);
				try {
					if (visitedUrls.contains(new URI(url))) {
						result = false;
					}
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println(url);
			url += "#";
			try {
				if (visitedUrls.contains(new URI(url))) {
					result = false;
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
//		if (!result)
//			System.out.println("uri:" +uri +" "+visitedUrls);
		return result;
	}

	public void visit(URI loc) {
		visitedUrls.add(loc);
	}
}