package sort;

public class ImprovedInsertion {

	public static void sort(Comparable[] a) {

		int sentinel_index = 0;
		Comparable<Comparable> sentinel_value = a[sentinel_index];

		// first we search for the sentinel
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(sentinel_value) < 0) {
				sentinel_value = a[i];
				sentinel_index = i;
			}
		}

		a[sentinel_index] = a[0];
		a[0] = sentinel_value;

		// int N = a.length;
		// for (int i = 2; i < N; i++) {
		// for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
		// exch(a, j, j - 1);
		// }

		for (int i = 2; i < a.length; i++) {
			int j = i;
			Comparable value = a[j];
			// while (a[j-1].compareTo(value ) > 0){
			while (value.compareTo(a[j - 1]) < 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = value;
		}
	}

	private static boolean less(Comparable<Comparable> comparable, Comparable comparable2) {
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
		ImprovedInsertion I = new ImprovedInsertion();

		I.print(a);
		I.sort(a);
		I.print(a);
	}
}