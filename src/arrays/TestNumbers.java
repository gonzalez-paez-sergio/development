package arrays;

class TestNumbers {

	public static void main(String[] string) {

		int[] arr = new int[] { 5, 4, 0, 3, 1, 6, 2 };

		System.out.println(solution(arr));

		arr = new int[] { 1, 0 };

		System.out.println(solution(arr));
		arr = new int[] { 0 };

		System.out.println(solution(arr));

	}

	public static int solution(int[] arr) {
		int max = 0;

		if (arr.length == 1)
			return 1;

		for (int i = 0; i < arr.length; i++) {
			// p will change only at the begining of every cycle
			int p = arr[i];
			int val = arr[p];
			int intCounter = 1;

			// p is our initial value, while we have different values
			// we need to go deep
			while (p != val) {
				// if we found the same value we already have a cycle, so we break the cycle
				// and update the max value
				val = arr[val];// redefine
				intCounter++;
			}

			if (max < intCounter) {
				max = intCounter;
			}
		}
		return max;

	}
}