package arrays;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Given an integer array, move the zero’s to the end of the integer array while
 * maintaining the order of the rest of the numbers
 * 
 * <pre>
 * Input 						Output 
 * [5,1,5, 0, 3, 3, 0, 9] -> 	[5,1,5,3,3,9,0,0]
 * [5,1,5, 0, 3, 3, 0, 9] -> 	[5,5,3,3,9,1,0,0] - wrong
 * [5,0,0,0,5] 			  -> 	[5,5,0,0,0]
 * </pre>
 */
public class Macy {

	public static void main(String[] string) {
		int[] arr = new int[] { 0, 0, 1, 0, 2, 0, 3, 4, 5, 0, 6, 7, 8, 0, 0, 9 };

		Macy macy = new Macy();
		MoveNumbers moveNumbers = macy.new MoveNumbers(0, arr);
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future<int[]> future = executorService.submit(moveNumbers);

		try {
			System.out.println(Arrays.toString(future.get()));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int[] moveZeros(int[] nums) throws InterruptedException {
		int[] nums1 = Arrays.copyOf(nums, nums.length + 1);

		nums1[nums1.length - 1] = Integer.MAX_VALUE;

		// System.out.println(Arrays.toString(nums) + " " + nums.length);
		// System.out.println(Arrays.toString(nums1) + " " + nums1.length);

		for (int i = 0; i < nums1.length; i++) {
			if (Integer.MAX_VALUE == nums1[i]) {
				nums1[i] = 0;
				return Arrays.copyOf(nums1, nums1.length - 1);
			}

			// System.out.printf("index:%s, current:%s\n", i, nums1[i]);
			if (0 == nums1[i]) {
				for (int j = i; j < nums1.length - 1; j++) {
					nums1[j] = nums1[j + 1];
				}
				nums1[nums1.length - 1] = 0;
				// System.out.println(Arrays.toString(nums1) + " " + nums1.length);

				if (0 == nums1[i]) {
					i--;
				}
			}

			// Thread.sleep(1000);
		}
		return nums;

	}

	class MoveNumbers implements Callable<int[]> {

		private int number;
		private int[] arr;

		/**
		 * 
		 * @param number
		 * @param arr
		 */
		public MoveNumbers(int number, int[] arr) {
			this.number = number;
			this.arr = arr;
		}

		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		@Override
		public int[] call() throws Exception {

			int tail = this.arr.length;

			for (int i = 0; i < tail;) {
				if (this.arr[i] == this.number) {
					// shift all the elements left
					for (int j = i; j < this.arr.length - 1; j++) {
						this.arr[j] = this.arr[j + 1];
					}

					// move the current number to the last position,
					this.arr[this.arr.length - 1] = number;

					// once moved, verify the current element
					if (this.arr[i] != this.number) {
						i++;
					}

					tail--;
				} else {
					i++;
				}
				System.out.printf("%s - i:%d ,tail:%d,%s\n", getClass(), i, tail, Arrays.toString(arr));
			}

			return arr;
		}
	}
}

// [5,1,5, 0, 3, 3, 0, 9]
//
//
// i=3, j=3, [5,1,5, 3, 3, 3, 0, 9]
// i=3, j=4, [5,1,5, 3, 3, 3, 0, 9]
// i=3, j=5, [5,1,5, 3, 3, 0, 0, 9]
//
//
// [5,1,5, 3, 3, 0, 9, 0]
// [5,1,5, 3, 3, 9, 0, 0]