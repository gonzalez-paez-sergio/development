package working.with.integer.numbers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * <pre>
 * given the stock in this days, find the best day for to buy & sell
 *
 * day to buy is < day to sell
 *
 * Price —> 23, 45, 2, 56, 20, 100, 43
 *
 * Days —-> 1, 2, 3, 4, 5, 6, 7
 *
 * </pre>
 *
 *
 * <pre>
 * Price —> 23, 45, 56, 20, 100, 43
 *
 * Days —-> 1, 2, 3, 4, 5, 6
 *
 * <pre>
 *
 * @author sergiogp
 *
 */
public class FindBestDeal {

  public static int[] getBestDeal(int[] arr) {
    int[] result = new int[2];
    for (int i = 1; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[result[1]] - arr[result[0]] < arr[j] - arr[i]) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  public static Map<Integer, Integer> sortByValuesDesc(Map<Integer, Integer> map) {
    List<Entry<Integer, Integer>> items =
        new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
    Comparator<Entry<Integer, Integer>> c = new LocalComparator();
    Collections.sort(items, c);

    System.out.println(items);
    return map;
  }

  static class LocalComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
      return o2.getValue().compareTo(o1.getValue());
    }
  }
}
