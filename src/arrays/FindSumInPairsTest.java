package arrays;

import org.junit.jupiter.api.Test;

class FindSumInPairsTest {

	@Test
	void test() {

		// int[][] result = { { 4, 1, -5 }, { -5, 6, -1 } };

		// int[] arr = { 4, 1, -5, 6, -1, 56 };
		// assertEquals(result, Sum.ThreeSum(0, arr));
		//
		// int[][] result1 = { { 2, 3, 4 } };
		// int[] arr1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		// assertEquals(result, Sum.ThreeSum(3, arr));

		int[] arr = new int[] { 1, -2, -3, 4, 5, -4, 7, 8, 4, -21, 2, 3, -4, 5, 6, 7, -3, 5, -3, -2, -1, 2 };
		FindSumInPairs.TwoSumImproved(0, arr);
		FindSumInPairs.TwoSumImproved(1, arr);
		FindSumInPairs.TwoSumImproved(2, arr);
		FindSumInPairs.TwoSumImproved(3, arr);
		FindSumInPairs.TwoSumImproved(4, arr);
		FindSumInPairs.TwoSumImproved(5, arr);
		FindSumInPairs.TwoSumImproved(6, arr);
		FindSumInPairs.TwoSumImproved(7, arr);
		FindSumInPairs.TwoSumImproved(8, arr);
		FindSumInPairs.TwoSumImproved(9, arr);
		FindSumInPairs.TwoSumImproved(10, arr);
		FindSumInPairs.TwoSumImproved(11, arr);
		FindSumInPairs.TwoSumImproved(12, arr);
	}
}