package algorithms;

public class ThreeSum {

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
}
