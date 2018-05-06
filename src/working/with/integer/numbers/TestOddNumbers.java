package working.with.integer.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestOddNumbers {

	public static void main(String[] string) {

		int[] arr = oddNumbers(2, 8);
		System.out.println(Arrays.toString(arr));
		arr = oddNumbers(2, 5398);
		System.out.println(Arrays.toString(arr));

		isContained(3, 3921);

		OddNumbers oddNumbers = new TestOddNumbers().new OddNumbers(2, 7);
		OddNumbers oddNumbers1 = new TestOddNumbers().new OddNumbers(2, 5398);
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Future<List<Integer>> future = executorService.submit(oddNumbers);
		Future<List<Integer>> future1 = executorService.submit(oddNumbers1);

		try {
			System.out.println((future.get()));
			System.out.println((future1.get()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

	static int[] oddNumbers(int l, int r) {
		int s = (int) Math.ceil((r - l) / 2) + 1;

		System.out.println(s);
		int[] arr = new int[s];
		int index = 0;
		for (int i = l; i <= r; i++) {
			if (0 != i % 2) {
				arr[index++] = i;
			}
		}
		return arr;
	}

	static boolean isContained(int digit, int i) {

		// 655
		while (i > 0) {
			int local = i % 10; // recover the last digit
			System.out.printf("locAL:%s, digit:%s, i:%s\n", local, digit, i);
			if (digit == local) {
				return true;
			}
			i = (i - local) / 10;
			// local = (i - local) / 10; //delete
		}
		return false;
	}

	/**
	 * 
	 * @author sergiogp
	 *
	 */
	class OddNumbers implements Callable<List<Integer>> {
		/**
		 * 
		 */
		private int begin;
		/**
		 * 
		 */
		private int end;

		/**
		 * 
		 * @param begin
		 * @param end
		 */
		public OddNumbers(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		/**
		 * 
		 */
		@Override
		public List<Integer> call() throws Exception {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = begin; i <= end; i++) {
				if (isOdd(i)) {
					list.add(i);
				}
			}

			return list;
		}

		/**
		 * 
		 * @param i
		 * @return
		 */
		private boolean isOdd(int i) {
			return i % 2 != 0;
		}
	}
}