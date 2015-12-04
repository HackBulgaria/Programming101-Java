package hashMap;

public class Test {

	public static void main(String[] args) {
		MyHashMap testMap = new MyHashMap();
		testMap.put("test_1", 1);
		System.err.println(testMap.get("test_1"));
		testMap.put("test_1", 3);
		System.err.println(testMap.containsKey("test_1"));
	}

}
