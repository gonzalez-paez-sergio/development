package arrays;

import java.util.Arrays;

/**
 * int Arr [] = {1,3,4,7,9,10,20,22,67}; Int value = 13; //question: how to insert value into Arr
 * without breaking sort order?
 *
 * @author sergiogp
 */
public class InsertValueIntoOrderedArray {

  public static void main(String[] string) {

    int[] i = new int[] {2, 4, 6, 7, 8};

    System.out.println(Arrays.toString(insert(5, i)));
    System.out.println(Arrays.toString(insert(15, i)));
    System.out.println(Arrays.toString(insert(2, i)));
    System.out.println(Arrays.toString(insert(1, i)));
    System.out.println(Arrays.toString(insert(0, i)));
  }

  public static int[] insert(int val, int[] arr) {
    int[] arrResult = Arrays.copyOf(arr, arr.length + 1); // create a new array of length +1
    for (int i = arr.length - 1; i > 0; i--) {
      arrResult[i + 1] = arrResult[i]; // shift elements forward
      if (arrResult[i + 1] <= val) { // if we found the right spot
        // System.out.printf("arrResult[i + 1]:%s, val:%s\n", arrResult[i + 1], val);

        arrResult[i + 1] = val; // place the new element and
        return arrResult; // break out the loop
      }
    }
    // if (arrResult.length > 1) {
    // System.out.printf("arrResult[1]:%s, arrResult[0]:%s\n", arrResult[1],
    // arrResult[0]);
    // if (arrResult[1] < arrResult[0]) {
    arrResult[1] = arrResult[0]; // shift elements forward
    arrResult[0] = val; // shift elements forward
    // }
    // }
    return arrResult;
  }
}
