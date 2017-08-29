package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ImprovedShell {
	public static void sort(Comparable[] a) { // Sort a[] into increasing order.

		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		}

		// int sentinel_index = 0;
		// Comparable<Comparable> sentinel_value = a[sentinel_index];
		//
		// // first we search for the sentinel
		// for (int i = 1; i < a.length; i++) {
		// if (a[i].compareTo(sentinel_value) < 0) {
		// sentinel_value = a[i];
		// sentinel_index = i;
		// }
		// }
		//
		// a[sentinel_index] = a[0];
		// a[0] = sentinel_value;

		// while (h >= 1) { // h-sort the array.
		// for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h],
		// // a[i-3*h]... .
		// for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
		// exch(a, j, j - h);
		// }
		// }
		// h = h / 3;
		// }

		while (h >= 1) { // h-sort the array.
			for (int i = 0; i < a.length; i++) {
				int j = i;
				Comparable value = a[j];
				// while (a[j-1].compareTo(value ) > 0){
				while (j >= h && value.compareTo(a[j - h]) < 0) {
					a[j] = a[j - h];
					j = j - h;
				}
				a[j] = value;
			}
			h = h / 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) { // Print the array, on a
												// single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) { // Test whether the
														// array entries are
														// in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) { // Read strings from standard
												// input, sort them, and
												// print.

//		Comparable[] a = { 23, 42, 4725, 16, 8, 15, 44, 5, 42452, 6342, 462562,
//				25, 43, 225, 24, 5, 2, 22854, 6, 2, 8, 6,
//				86, 4111, 5, 6, 234, 34, 52, 345, 234, 52, 345, 23, 45, 23, 5234, 
//				5, 234, 6, 7, 356, 7, 5, 635, 5462, 34,
//				27, 4, 7, 3645, 735, 345, 73, 45637, 24, 573, 3457, 354, 734, 57, 3547353, 5, 3457, 54 };
//		Insertion I = new Insertion();
//		show(a);

		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
