package algorithms;

import java.util.Arrays;

public class ThreeSum {

  BinarySearch binarySearch = new BinarySearch();
  // count number of triples that sum 0
  public int count(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        for (int k = j + 1; k < a.length; k++) {
          if (0 == a[i] + a[j] + a[k]) {
            result++;
          }
        }
      }
    }
    return result;
  }

  public int countEnhanced(int[] a) {
    Arrays.sort(a);
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        int r = binarySearch.rank(-(a[i] + a[j]), a);
        if (-1 < r && j < r) {
          result++;
        }
      }
    }
    return result;
  }

  public int countEnhancedEnhanced(int[] a) {
    Arrays.sort(a);
    int result = 0;
    for (int i = 0; i < a.length - 2; i++) {

      int end = a.length - 1;
      int first = i + 1;
      while (first < end) {
        int aend = a[end];
        int afirst = a[first];
        // System.out.printf(
        // "aend:%s, afirst:%s, a[i]:%s, sum:%s\n", aend, afirst, a[i], (a[i] + aend + afirst));
        if (a[i] + aend + afirst == 0) {
          result++;
          first++;
          end--;
        } else if (a[i] + aend + afirst > 0) {
          end--;
        } else {
          first++;
        }
      }
    }
    return result;
  }
}
