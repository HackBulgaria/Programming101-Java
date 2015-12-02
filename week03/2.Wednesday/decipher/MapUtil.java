package decipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {

	public static <K, V extends Comparable<V>> List<K> sortByValue(Map<K, V> map) {
		List<K> sortedList = new ArrayList<>();

		List<Entry<K, V>> entries = new ArrayList<>(map.entrySet());
		// performs descending sort
		Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> firstEntry, Entry<K, V> secondEntry) {
				return secondEntry.getValue().compareTo(firstEntry.getValue());
			}

		});

		for (Entry<K, V> entry : entries) {
			sortedList.add(entry.getKey());
		}

		return sortedList;
	}
}
