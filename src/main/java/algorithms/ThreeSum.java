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
        int r =  binarySearch.rank(-(a[i] + a[j]),a);
        if (-1<r &&j<r) {
          result++;
        }
      }
    }
    return result;
  }

  public int countEnhancedWithSortedArray(int[] a) {
    System.out.println(a);
    Arrays.sort(a);
    System.out.println(a);
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (-1 != binarySearch.rank(-(a[i] + a[j]), a)) {
          result++;
        }
      }
    }
    return result;
  }
}
