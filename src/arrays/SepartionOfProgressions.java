package arrays;

/***
 * write a program that takes one integer N [2 , 20] and an array of N integers
 * as input. This array is composed of three arithmetic progressions (AP) linked
 * together in exactly two links
 * 
 * your program needs to output each AP separated by one line in the order of
 * the input
 * 
 * 
 * <pre>
 * 
 * input
 * 8
 * 
 * 1 2 3 7 10 13 22 24
 *  
 * output
 * 1 2 3
 * 
 * 7 10 13
 * 
 * 22 24
 * 
 * 
 * 
 * input
 * 9
 * 
 * 6 10 14 2 8 14 100 101 102
 * 
 * 
 * output
 * 6 10 14
 * 
 * 2 8 14
 * 
 * 100 101 102
 * 
 * 
 * 
 * </pre>
 * 
 * 
 * @author sergiogp
 *
 */
public class SepartionOfProgressions {

	public static void main(String[] string) {
		int[] arr = new int[] { 6, 10, 14, 2, 8, 14, 100, 101, 102 };
		test(arr);

		System.out.println();
		arr = new int[] { 1, 2, 3, 7, 10, 13, 22, 24 };
		test(arr);

		System.out.println();
		arr = new int[] { 3, 10, 24 };
		test(arr);
	}

	public static void test(int[] arr) {
		if (arr.length <= 3) {
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%d ", arr[i]);

			}
			return;
		}

		System.out.printf("%d ", arr[0]);
		for (int i = 1, diff1 = arr[i] - arr[i - 1]; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] == diff1) {
				// we are on the same progression
				System.out.printf("%d ", arr[i]);
			} else {
				System.out.println();
				diff1 = arr[i + 1] - arr[i];
				System.out.printf("%d ", arr[i]);
			}
		}
	}
}
