package sort;

public class Insertion {
	public static void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length;
		for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
				exch(a, j, j-1);
			}
		}
// See page 245 for less(), exch(), isSorted(), and main().

	private static boolean less(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void exch(Comparable[] a, int j, int i) {
		// TODO Auto-generated method stub
		
	}
}

	//shellsort
//	while (h >= 1) { // h-sort the array.
//		for (int i = h; i < N; i++) { // 
//			for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
//				exch(a, j, j - h);
//			}
//		}
//		h = h / 3;
//	}
