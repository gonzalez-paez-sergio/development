package lambda;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * <pre>
 * 
 * <pre>
 * 
 * @author sergiogp
 *
 */
public class SortedByValue {

	public static void main(String[] string) {

		Map<Integer, Integer> map = new HashMap<>();

		map.put(2, 34);

		map.put(1, 45);

		map.put(5, 30);

		sortByValuesDesc(map);
		Map<Integer, Integer> result = new HashMap<>();
		map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
				.forEach(p -> result.put(p.getKey(), p.getValue()));

		System.out.println(result);

		// sortByValues(map, item, );
	}

	public static void sortByValuesDesc(Map<Integer, Integer> map) {
		List<Entry<Integer, Integer>> items = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(items, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		System.out.println(items);
	}
}
