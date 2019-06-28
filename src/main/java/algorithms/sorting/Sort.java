package algorithms.sorting;

public class Sort {
  public static <T extends Comparable> boolean isSorted(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (lessThan(arr[i], arr[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static <T extends Comparable> boolean lessThan(T t1, T t2) {
    return 0 > t1.compareTo(t2);
  }

  public static <T extends Comparable> void exch(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
