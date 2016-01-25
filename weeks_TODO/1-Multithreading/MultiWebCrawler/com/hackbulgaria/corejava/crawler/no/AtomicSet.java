package com.hackbulgaria.corejava.crawler.no;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AtomicSet implements Set<URI> {
	
	@Override
	public String toString() {
		return handle.toString();
	}

	private Set<URI> handle = 
			Collections.synchronizedSet(new HashSet<URI>());

	@Override
	public int size() {
		return handle.size();
	}

	@Override
	public boolean isEmpty() {
		return handle.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		synchronized (this) {
			boolean result = handle.contains(o);
			if (!result) {
				if (!(o instanceof URI)) {
					throw new RuntimeException(o.getClass().toString());
				}
				if (!handle.add((URI) o)) {
					throw new RuntimeException("Element not added: " + o);
				};
			}
			return result;
		}
	}

	@Override
	public Iterator<URI> iterator() {
		return handle.iterator();
	}

	@Override
	public Object[] toArray() {
		return handle.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return handle.toArray(a);
	}

	@Override
	public boolean add(URI e) {
		return handle.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return handle.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return handle.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends URI> c) {
		return handle.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return handle.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return handle.removeAll(c);
	}

	@Override
	public void clear() {
		handle.clear();
	}

}
