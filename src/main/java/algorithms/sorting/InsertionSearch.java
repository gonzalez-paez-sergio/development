
package algorithms.sorting;

public class InsertionSearch {

  public static void main (String[] string) {
    int [] arr = new int[] {3,5,7,3,1,47,8,7,5,4};

    InsertionSearch insertionSearch = new InsertionSearch();
    insertionSearch.sort(arr);
    insertionSearch.print(arr);
  }

public void print(int [] arr ){
  for(int i = 0 ; i<arr.length;i++){
    System.out.printf("%s, ",arr[i]);
  }
  System.out.println();

}

  public void sort(int[] arr ) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          exch(arr,i,j);
        }
      }
    }
  }

  public void exch(int [] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
