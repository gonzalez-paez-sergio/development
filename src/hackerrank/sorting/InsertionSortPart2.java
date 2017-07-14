package hackerrank.sorting;

import java.util.Scanner;

/***
 * <pre>
 * 
 * In Insertion Sort Part 1, you sorted one element into an array. Using the same approach repeatedly, can you sort an entire unsorted array?

Guideline: You already can place an element into a sorted array. How can you use that code to build up a sorted array, one element at a time? Note that in the first step, when you consider an array with just the first element - that is already "sorted" since there's nothing to its left that is smaller.

In this challenge, don't print every time you move an element. Instead, print the array after each iteration of the insertion-sort, i.e., whenever the next element is placed at its correct position.

Since the array composed of just the first element is already "sorted", begin printing from the second element and on.

Input Format
There will be two lines of input:

    - the size of the array
    - a list of numbers that makes up the array

Output Format
On each line, output the entire array at every iteration.

Constraints

Sample Input

6
1 4 3 5 6 2

Sample Output

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 

Explanation
Insertion Sort checks first and doesn't need to move it, so it just prints out the array. Next, is inserted next to , and the array is printed out. This continues one element at a time until the entire array is sorted.

Task
The method insertionSort takes in one parameter: , an unsorted array. Use an Insertion Sort Algorithm to sort the entire array.
 * </pre>
 * 
 * @author sergio
 *
 */
public class InsertionSortPart2 {

	public static void sort(int[] ar) {
		for (int i = 2; i <= ar.length; i++) {
			/*
			 * sort the array by dividing it we sort the subarray formed by the
			 * first 2 elements, next we sort the subarray formed by the 3
			 * elements and so on
			 */
			insertIntoSorted(ar, i);
			/* every iteration we print the array */
			printArray(ar);
		}
	}

	/*
	 * insert the ar[end-1] element in the ordered array of size end-2 keeping
	 * the order, returns the (end-1)-ordered array
	 */
	public static void insertIntoSorted(int[] ar, int end) {
		if (end > 0) {
			int val = ar[end - 1];
			int i = 0;
			for (i = end - 2; i >= 0; i--) {
				if (val < ar[i]) {
					ar[i + 1] = ar[i];
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
			// printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int s = in.nextInt();
			int[] ar = new int[s];
			for (int i = 0; i < s; i++) {
				ar[i] = in.nextInt();
			}
			sort(ar);

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
