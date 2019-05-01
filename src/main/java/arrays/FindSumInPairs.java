package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * given an array of integer and a target, write a function to return all the pairs that have
 * summations equals to the target
 *
 * @author sergiogp
 */
public class FindSumInPairs {

  public static Object[] ThreeSum(int intTarget, int[] arr) {
    List<int[]> list = new ArrayList<int[]>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (intTarget == arr[i] + arr[j] + arr[k]) {
            int[] sdafsdf = {arr[i], arr[j], arr[k]};
            list.add(sdafsdf);
          }
        }
      }
    }

    print3Array(list);
    return list.toArray();
  }

  public static Object[] TwoSum(int intTarget, int[] arr) {
    List<int[]> list = new ArrayList<int[]>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (intTarget == arr[i] + arr[j]) {
          int[] t = {arr[i], arr[j]};
          list.add(t);
        }
      }
    }

    print2Array(list);
    return list.toArray();
  }

  public static Object[] TwoSumImproved(int intTarget, int[] arr) {

    System.out.printf("\ntarget:%d\n", intTarget);

    List<int[]> list = new ArrayList<int[]>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      int intResultIndex = search(intTarget - arr[i], arr);
      //			System.out.printf("intTarget=%d, resultIndex=%d, i=%d,current value=%d,
      // searchingfor=%d\n", intTarget,
      //					intResultIndex, i, arr[i], intTarget - arr[i]);
      if (i < intResultIndex) { // strictly less than the result to avoid duplicates
        // this is a valid index
        int[] t = {arr[i], arr[intResultIndex]};
        list.add(t);
      }
    }
    print2Array(list);
    return list.toArray();
  }

  private static int search(int key, int[] arr) {

    int lo = 0;
    int hi = arr.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < arr[mid]) hi = mid - 1;
      else if (key > arr[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  private static void print2Array(List<int[]> list) {
    for (Object element : list) {
      int arr[] = (int[]) element;
      System.out.printf("i=%s,j=%s; ", arr[0], arr[1]);
    }
  }

  private static void print3Array(List<int[]> list) {
    for (Object element : list) {
      int arr[] = (int[]) element;
      System.out.printf("list: i=%s,j=%s,k=%s\n", arr[0], arr[1], arr[2]);
    }
  }
}
