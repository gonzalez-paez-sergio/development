package arrays;
 
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

class MyCode {
	public static void main(String[] args) {
		System.out.println("Hello Java");

		int w = 0;
		String string = "abcdefghijklmnopqrstuvwxyz";

		int iterations = (int) Math.floor(w / 27);

		int intCounter = 0;
		String stringResult = new String();
		// 60 = 2*27+6
		// aaf
		while (intCounter < iterations) { // we are going to iterate as many entire times as we can
			stringResult += string.charAt(intCounter++);// adding the current

		}

		stringResult += string.charAt(w % 27);

		System.out.println(stringResult);

		findCEO();
	}

	/**
	 * find the CEO
	 * 
	 * <pre>
	 * A is the boos of C 
	 * B is the boss of C
	 * B is the boss of C
	 * B is the boss of C
	 * 
	 * </pre>
	 * 
	 */
	public static void findCEO() {
		Map<String, String> map = new HashMap<String, String>();

		map.put("A", "C");
		map.put("B", "C");
		map.put("C", "F");
		map.put("D", "E");
		map.put("E", "F");
		map.put("F", "F");

		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		Set<String> iterator = map.keySet();
		int max = 0;

		String stringMax = new String();
		for (String stringKey : iterator) {
			String stringValue = map.get(stringKey);

			Integer counter = hashtable.get(stringValue);

			if (null != counter) {
				hashtable.put(stringValue, ++counter);
				if (max < counter) {
					max = counter;
					stringMax = stringValue;
				}
			} else {
				hashtable.put(stringValue, 1);
			}
		}

		System.out.printf("stringMax:%s, hashtable:%s", stringMax, hashtable);
	}
}
