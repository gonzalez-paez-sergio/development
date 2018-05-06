package working.with.integer.numbers;

public class SecondLargestAndSmallestNumber {

	public static int secondLargestNumber(int[] arr) {

		int intMax = Integer.MIN_VALUE, intSecondMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// if (i == 0)
			if (intMax < arr[i]) {
				intSecondMax = intMax;
				intMax = arr[i];
			} else if (arr[i] > intSecondMax && arr[i] != intMax) {
				intSecondMax = arr[i];
			}
		}

		return intSecondMax;
	}

	public static Object secondSmallestNumber(int[] arr) {
		int intMin = Integer.MAX_VALUE, intSecondMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (intMin > arr[i]) {
				intSecondMin = intMin;
				intMin = arr[i];
			} else if (intSecondMin > arr[i]) {
				intSecondMin = arr[i];
			}
		}

		// System.out.printf("intMin=%d, intSecondMin=%d", intMin, intSecondMin);
		return intSecondMin;
	}
}
