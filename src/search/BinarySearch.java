package search;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static int rank(int key, int[] a) { // Array must be sorted.
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) { // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static int rank(int key, int[] a, int intLowIndex, int intHighIndex) {

		if (intHighIndex < intLowIndex) {
			return -1;
		}

		int intMiddleIndex = intLowIndex + (intHighIndex - intLowIndex) / 2;
		if (key < a[intMiddleIndex]) {
			return rank(key, a, intLowIndex, intMiddleIndex - 1);
		} else if (a[intMiddleIndex] < key) {
			return rank(key, a, intMiddleIndex + 1, intHighIndex);
		} else
			return intMiddleIndex;
	}

	// 1 3 4 6 7 9
	// 5

	public static void main(String[] args) {

		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
			int key = StdIn.readInt();
			// if (rank(key, whitelist) < 0){
			if (rank(key, whitelist, 0, whitelist.length - 1) < 0) {
				StdOut.println(key);
			}
		}
		System.out.println("1");
	}
}
