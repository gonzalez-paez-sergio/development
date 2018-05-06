package arrays;

import java.util.List;
import java.util.Random;

public class Helper {
	public static void print(List<Integer> arr) {
		printObjects(arr.toArray());
	}

	public static void printObjects(Object[] arr) {
		for (Object string : arr) {
			System.out.printf("%s, ", string);
		}
		System.out.println();
	}

	public static void print(int[] arr) {
		for (int intItem : arr) {
			System.out.printf("%s, ", intItem);
		}
		System.out.println();
	}

	public static int[] generateArray(String string, int init, int end) {

		int[] res = null;
		int j = 0;
		switch (string) {
		case "asc":
			res = new int[end - init];
			j = 0;
			for (int i = init; i < end; i++) {
				res[j++] = i;
			}
			return res;
		case "desc":
			res = new int[end - init];
			j = 0;
			for (int i = end; i > init; i--) {
				res[j++] = i;
			}
			return res;
		case "random":
			res = new int[end - init];
			Random random = new Random();
			for (int i = init; i < end; i++) {
				res[i] = random.nextInt(end);
			}
			return res;

		default:
			break;
		}
		return null;

	}

}
