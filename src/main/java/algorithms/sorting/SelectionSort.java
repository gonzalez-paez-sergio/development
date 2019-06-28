package algorithms.sorting;

public class SelectionSort extends Sort {

  public static <T extends Comparable> void sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      // for every i in the array we try to find the minor element in the
      // subarray [i, arr.length], this element will be saved in the i-position
      for (int j = i; j < arr.length; j++) {
        if (lessThan(arr[j], arr[i])) {
          exch(arr, i, j);
        }
      }
    }
  }
}
