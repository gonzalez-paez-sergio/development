package algorithms.sorting;

public class SelectionSort<T extends Comparable> {
  public static void main (String[] args){
    String[] arr = new String[] {"a", "b", "t"};
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.sort(arr);
    selectionSort.print(arr);
  }

  public void print(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%s, ", arr[i]);
    }
    System.out.println();
  }

  public void sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (lessThan(arr[j], arr[j-1])) {
          exch(arr, j-1, j);
        } else {break;}
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
