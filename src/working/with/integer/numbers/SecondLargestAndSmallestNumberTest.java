package working.with.integer.numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Find the second largest smallest number given an array as an input
 * 
 * @author sergiogp
 *
 */
class SecondLargestAndSmallestNumberTest {

	@Test
	void test() {

		int[] arr = new int[] { 2, 4, 5, 6, 7, 2, 1, 34, 0, 3, 40, 2 };
		assertEquals(34, SecondLargestAndSmallestNumber.secondLargestNumber(arr));
		assertEquals(1, SecondLargestAndSmallestNumber.secondSmallestNumber(arr));

		int[] arr1 = new int[] { -1, 0 };
		assertEquals(-1, SecondLargestAndSmallestNumber.secondLargestNumber(arr1));
		assertEquals(0, SecondLargestAndSmallestNumber.secondSmallestNumber(arr1));

		int[] arr2 = new int[] { -9, -9, -67, -8, -4, -72, -91, -03, -42, -30, -40, -23 };
		assertEquals(-4, SecondLargestAndSmallestNumber.secondLargestNumber(arr2));
		assertEquals(-72, SecondLargestAndSmallestNumber.secondSmallestNumber(arr2));

		int[] arr3 = new int[] { 1, 3, 2, 0 };
		assertEquals(2, SecondLargestAndSmallestNumber.secondLargestNumber(arr3));
		assertEquals(1, SecondLargestAndSmallestNumber.secondSmallestNumber(arr3));

		int[] arr4 = new int[] { 0, 1, 2, 3 };
		assertEquals(2, SecondLargestAndSmallestNumber.secondLargestNumber(arr4));
		assertEquals(1, SecondLargestAndSmallestNumber.secondSmallestNumber(arr4));
	}

}
