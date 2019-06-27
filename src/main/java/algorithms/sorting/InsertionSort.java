package algorithms.sorting;

public class InsertionSort<T extends Comparable> {

  public static void main(String[] string) {
    String[] arr = new String[] {"a", "b", "t"};
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.sort(arr);
    insertionSort.print(arr);
  }

  public void print(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%s, ", arr[i]);
    }
    System.out.println();
  }

  public void sort(T[] arr) {
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

  public boolean lessThan(T t1, T t2) {
    return 0 > t1.compareTo(t2);
  }

  public void exch(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
