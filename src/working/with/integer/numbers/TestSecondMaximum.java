/**
 * 
 */
package working.with.integer.numbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author sergiogp
 *
 */
public class TestSecondMaximum {

	@Test
	public void test() {
		int[] arr = new int[] { 3, 5, 7, 9, 0, 4, 3, 2, 1 };
		assertEquals(7, SecondMaximum.calculate(arr));
		assertEquals(2, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testAlmostAllEquals() {
		int[] arr = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		assertEquals(6, SecondMaximum.calculate(arr));
		assertEquals(11, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testAlmostAllEquals2() {
		int[] arr = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		assertEquals(8, SecondMaximum.calculate(arr));
		// this test case is useless because there are so much second max
		// assertEquals(10, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testAllEquals() {
		int[] arr = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		assertEquals(-1, SecondMaximum.calculate(arr));
		assertEquals(-1, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testTwoElement() {
		int[] arr = new int[] { 3, 2 };
		assertEquals(2, SecondMaximum.calculate(arr));
		assertEquals(1, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testTwoElementInverted() {
		int[] arr = new int[] { 2, 3 };
		assertEquals(2, SecondMaximum.calculate(arr));
		assertEquals(0, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testAscendentArray() {
		int[] arr = new int[] { 1, 23, 45, 67, 87, 212, 512, 655 };
		assertEquals(512, SecondMaximum.calculate(arr));
		assertEquals(6, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testDescendentArray() {
		int[] arr = new int[] { 9493, 39, 38, 1 };
		assertEquals(39, SecondMaximum.calculate(arr));
		assertEquals(1, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void test888899() {
		int[] arr = new int[] { 8, 8, 8, 8, 99 };
		assertEquals(8, SecondMaximum.calculate(arr));
		assertEquals(0, SecondMaximum.calculateIndex(arr));
	}

	@Test
	public void testNegativo() {
		int[] arr = new int[] { 8, 5, 9 };
		assertEquals(8, SecondMaximum.calculate(arr));
		assertEquals(0, SecondMaximum.calculateIndex(arr)); 
	}

}
