package algorithms.sorting;

public class ShellSort extends Sort {

  public static <T extends Comparable> void sort(T[] arr) {
    int h = 1;
    while (h < arr.length / 3) h = 3 * h + 1;
    while (h > 0) {
      for (int i = h; i < arr.length; i++) {
        for (int j = i; j >= h; j -= h) {
          if (lessThan(arr[j], arr[j - h])) {
            exch(arr, j - h, j);
          } else {
            break;
          }
        }
      }
      h /= 3;
    }
  }

  public static <T extends Comparable> boolean isHSorted(T[] arr, int h) {
    for (int i = h; i < arr.length; i++) {
      if (lessThan(arr[i], arr[i - h])) {
        return false;
      }
    }
    return true;
  }
}
