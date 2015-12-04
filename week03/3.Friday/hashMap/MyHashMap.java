package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
	private int capacity;
	private List<List<Entry>> buckets;

	public MyHashMap() {
		capacity = 16; // 16 is initial capcity
		buckets = new ArrayList<>(capacity);
		init(buckets, capacity);
	}

	private void init(List<List<Entry>> buckets, int capacity) {
		for(int i=0; i<capacity; i++) {
			buckets.add(new LinkedList<Entry>());
		}
	}

	private int hash(String key) {
		return Math.abs((key.hashCode() % capacity));
	}

	public void put(String key, Integer value) {
		if (key == null) {
			return;
		}

		int position = hash(key);
		List<Entry> bucket = buckets.get(position);

		if (bucket == null) {
			bucket = new LinkedList<>();
		}

		for (Entry entry : bucket) {
			if (key.equals(entry.getKey())) {
				entry.setValue(value);
				return;
			}
		}

		Entry newEntry = new Entry(key, value);
		bucket.add(newEntry);
	}

	public Integer get(String key) {
		if (key == null) {
			return null;
		}

		int position = hash(key);
		List<Entry> bucket = buckets.get(position);

		if (bucket == null) {
			return null;
		}

		for (Entry entry : bucket) {
			if (key.equals(entry.getKey())) {
				return entry.getValue();
			}
		}

		return null;
	}

	public boolean containsKey(String key) {
		if (key == null) {
			return false;
		}

		Integer value = get(key);
		if (value != null) {
			return true;
		}
		return false;
	}
}
