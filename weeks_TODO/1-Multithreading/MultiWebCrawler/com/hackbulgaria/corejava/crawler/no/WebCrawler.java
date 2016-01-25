package com.hackbulgaria.corejava.crawler.no;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WebCrawler {
	private final Set<URI> visitedUrls = Collections
			.synchronizedSet(new HashSet<URI>());

	// private final Set<URI> finalResult = Collections.synchronizedSet(new
	// HashSet<URI>());

	public Set<URI> crawl(URI currentLocation, final String needle)
			throws URISyntaxException, MalformedURLException,
			InterruptedException, ExecutionException {
		Set<URI> finalResult = Collections.synchronizedSet(new HashSet<URI>());
		String urlContents = downloadContents(currentLocation);
		visitedUrls.add(currentLocation);

		if (urlContents.contains(needle)) {
			// return
			finalResult.add(currentLocation);
			System.out.println("found in " + currentLocation);
		}
		{
			Set<String> allLinks = getAllLinks(urlContents);
			removeNotNeededLinks(allLinks);
			for (String link : allLinks) {
				final URI asUri = normalizeLink(currentLocation, link);
				if (asUri != null && !visitedUrls.contains(asUri)
						&& isInsideDomain(currentLocation, asUri)) {
					Set<URI> result = crawl(asUri, needle);
					if (result != null) {
						finalResult.addAll(result);
					}
				}
			}
		}
		return finalResult;
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
}