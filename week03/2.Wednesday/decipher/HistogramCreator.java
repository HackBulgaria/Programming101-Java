package decipher;

import java.util.HashMap;
import java.util.Map;

public class HistogramCreator {
	
	public static Map<Character, Integer> getHistogram(String cryptedString) {
		String processedInput = cryptedString.replaceAll("\\W", "");
		
		Map<Character, Integer> histogram = new HashMap<>();
		
		for(int i=0; i < processedInput.length(); i++) {
			Character ch = Character.toLowerCase(processedInput.charAt(i));
			if(histogram.containsKey(ch)) {
				histogram.put(ch, histogram.get(ch)+1);
			} else {
				histogram.put(ch, 1);
			}
		}
		
		return histogram;
	}
	
	
}
