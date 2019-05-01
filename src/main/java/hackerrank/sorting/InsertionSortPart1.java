package hackerrank.sorting;

import java.util.Scanner;

/**
 *
 *
 * <pre>
 * Sorting
 * One common task for computers is to sort data. For example, people might want to see all their files on a computer sorted by size. Since sorting is a simple problem with many different possible solutions, it is often used to introduce the study of algorithms.
 *
 * Insertion Sort
 * These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm. We will first start with an already sorted list.
 *
 * Insert element into sorted list
 * Given a sorted list with an unsorted number in the rightmost cell, can you write some simple code to insert into the array so that it remains sorted?
 *
 * Print the array every time a value is shifted in the array until the array is fully sorted. The goal of this challenge is to follow the correct order of insertion sort.
 *
 * Guideline: You can copy the value of to a variable and consider its cell "empty". Since this leaves an extra cell empty on the right, you can shift everything over until can be inserted. This will create a duplicate of each value, but when you reach the right spot, you can replace it with .
 *
 * Input Format
 * There will be two lines of input:
 *
 * - the size of the array
 * - the array containing sorted integers and unsorted integer in the rightmost cell
 *
 * Output Format
 * On each line, output the entire array every time an item is shifted in it.
 *
 * Constraints
 *
 * Sample Input
 *
 * 5
 * 2 4 6 8 3
 *
 * Sample Output
 *
 * 2 4 6 8 8
 * 2 4 6 6 8
 * 2 4 4 6 8
 * 2 3 4 6 8
 *
 * Explanation
 *
 * 3 is removed from the end of the array.
 * In the 1st line 8>3, so is shifted one cell to the right.
 * In the 2nd line 6>3, so is shifted one cell to the right.
 * In the 3rd line 4>3, so is shifted one cell to the right.
 * In the 4th line 2<3, so is placed at position .
 *
 * Task
 *
 * Complete the method insertionSort which takes in one parameter:
 *
 * - an array with the value in the right-most cell.
 *
 * Next Challenge
 *
 * In the next Challenge, we will complete the insertion sort itself!
 *
 *
 * </pre>
 */
public class InsertionSortPart1 {

  public static void insertIntoSorted(int[] ar) {
    // save the value in the rightmost cell
    if (ar.length > 0) {
      int val = ar[ar.length - 1];
      int i = 0;
      for (i = ar.length - 2; i >= 0; i--) {
        if (val < ar[i]) {
          ar[i + 1] = ar[i];
          printArray(ar);
        } else {
          ar[i + 1] = val;
          break;
        }
      }

      /*
       * the case when the element to insert is the smaller is covered
       * with this fragment
       */
      if (-1 == i) {
        ar[0] = val;
      }
      printArray(ar);
    }
  }

  /* Tail starts here */
  public static void main(String[] args) {

    Scanner in = null;
    ;
    try {
      in = new Scanner(System.in);
      int s = in.nextInt();
      int[] ar = new int[s];
      for (int i = 0; i < s; i++) {
        ar[i] = in.nextInt();
      }
      insertIntoSorted(ar);
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      in.close();
    }
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }
}
