package arrays.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {
		assertEquals(0, Fibonacci.calculateNoArray(0), .001);
	}

	@Test
	public void test1() {
		assertEquals(1, Fibonacci.calculateNoArray(1), .001);
	}

	@Test
	public void test2() {
		assertEquals(1, Fibonacci.calculateNoArray(2), .001);
	}

	@Test
	public void test3() {
		assertEquals(2, Fibonacci.calculateNoArray(3), .001);
	}

	@Test
	public void test4() {
		assertEquals(3, Fibonacci.calculateNoArray(4), .001);
	}

	@Test
	public void test5() {
		assertEquals(5, Fibonacci.calculateNoArray(5), .001);
	}

	@Test
	public void test6() {
		assertEquals(8, Fibonacci.calculateNoArray(6), .001);
	}

	@Test
	public void test7() {
		assertEquals(13, Fibonacci.calculateNoArray(7), .001);
	}

	@Test
	public void test8() {
		assertEquals(21, Fibonacci.calculateNoArray(8), .001);
	}

}
