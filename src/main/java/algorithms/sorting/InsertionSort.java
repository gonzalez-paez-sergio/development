package algorithms.sorting;

public class InsertionSort  extends Sort{

  public static <T extends Comparable> void sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (lessThan(arr[j], arr[j - 1])) {
          exch(arr, j - 1, j);
        } else {
          break;
        }
      }
    }
  }
}
