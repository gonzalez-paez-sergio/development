package sort;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		return comparable.compareTo(comparable2) < 0;
	}

	private static void exch(Comparable[] a, int j, int i) {

		Comparable tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;

	}

	public static void print(Comparable[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Comparable[] a = { 23, 42, 4, 16, 8, 15 };
		Insertion I = new Insertion();

		I.print(a);
		I.sort(a);
		I.print(a);
	}
}