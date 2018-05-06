package working.with.integer.numbers;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestFindBestDeal {

	@Test
	public void test() {

		int[] arr = new int[] { 0, 23, 45, 56, 20, 100, 43 };
		int[] result = new int[] { 4, 5 };

		assertArrayEquals(result, FindBestDeal.getBestDeal(arr));
	}

	@Test
	public void test1() {

		int[] arr = new int[] { 0, 23, 45, 2, 56, 20, 100, 43 };
		int[] result = new int[] { 3, 6 };

		assertArrayEquals(result, FindBestDeal.getBestDeal(arr));
	}

	@Test
	public void test2() {

		int[] arr = new int[] { 0, 23, 45, 20, 2, 56, 43, 100 };
		int[] result = new int[] { 4, 7 };

		assertArrayEquals(result, FindBestDeal.getBestDeal(arr));
	}

}
