package com.hackbulgaria.corejava;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;

public class WebCrawler {
	private final Set<URI> visitedUrls = Collections.synchronizedSet(new HashSet<URI>());

	public URI crawl(URI currentLocation, final String needle) throws URISyntaxException, MalformedURLException,
			InterruptedException, ExecutionException {
		String urlContents = downloadContents(currentLocation);
		visitedUrls.add(currentLocation);

		if (urlContents.contains(needle)) {
			return currentLocation;
		} else {
			for (String link : getAllLinks(urlContents)) {
				final URI asUri = normalizeLink(currentLocation, link);
				if (!visitedUrls.contains(asUri) && isInsideDomain(currentLocation, asUri)) {
					URI result = crawl(asUri, needle);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}

	private static boolean isInsideDomain(URI currentLocation, URI asUrl) throws URISyntaxException {
		return currentLocation.getHost().equals(asUrl.getHost());
	}

	private URI normalizeLink(URI currentLocation, String link) throws MalformedURLException, URISyntaxException {
		URI uri = new URI(link);
		if (uri.getScheme() != null && uri.getHost() != null) {
			return uri;
		}
		return URIUtils.resolve(currentLocation, uri);
	}

	private static String downloadContents(URI startLocation) throws URISyntaxException {
		HttpClient httpClient = new DefaultHttpClient();
		System.out.println("Currently crawling : " + startLocation);
		HttpGet get = new HttpGet(startLocation);
		try {
			HttpResponse response = httpClient.execute(get);
			String contents = IOUtil.toString(response.getEntity().getContent());
			return contents;
		} catch (IOException e) {
			e.printStackTrace();
			// IO Error when connecting to the server, whatever, just return
			// empty contents
			return "";
		}
	}

	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}
}
