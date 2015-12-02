package decipher;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<Character, Integer> map = HistogramCreator.getHistogram("bcdaab");
		List<Character> charList = MapUtil.sortByValue(map);
		System.out.println(charList);
	}
}
