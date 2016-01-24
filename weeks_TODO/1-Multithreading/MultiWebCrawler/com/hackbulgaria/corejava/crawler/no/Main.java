package com.hackbulgaria.corejava.crawler.no;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.hackbulgaria.corejava.crawler.no.ParalelWebCrawler;

public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException,
			ExecutionException {
		long start = System.currentTimeMillis();
//		WebCrawler crawler = new WebCrawler();
		ExecutorService service = Executors.newCachedThreadPool();
		ParalelWebCrawler crawler = new ParalelWebCrawler(service);

//		String url = "http://9gag.com/";
//		String needle = "junk";
		String url = "http://blog.hackbulgaria.com";
		String needle = "Python";
		
		AtomicInteger in = new AtomicInteger();

		URI startLocation = new URI(url);
		crawler.visit(startLocation);
		Set<URI> result = crawler.crawl(startLocation, needle, in);
		
		while (!in.compareAndSet(0, 0)) {
			synchronized (in) {
				in.wait();
			}
		}
		service.shutdown();
		
		System.out.println("result: " + result.toString());
		
		for (URI uri : result) {
			System.out.println(uri);
		}
		System.out.println("links: " + result.size());
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

}