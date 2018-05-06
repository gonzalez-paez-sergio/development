package arrays.fibonacci;

import java.util.ArrayList;
import java.util.List;

import arrays.Helper;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * 
 */

public class CountFibonacciNumbers {
	public static void main(String[] args) {
		if (countFibonacciNumbers(10, 100) == 5) {
			System.out.println("Passed");
			return;
		}
		System.out.println("Failed");
	}

	static int countFibonacciNumbers(int low, int high) {
		List<Integer> listResult = new ArrayList<Integer>();
		List<Integer> arr = new ArrayList<Integer>();
		Integer currentFibonacci = 0;
		for (int i = 0; currentFibonacci <= high; i++) {
			// currentFibonacci = fibonacci(i);
			currentFibonacci = fibonacci2(i, arr);
			System.out.printf("currentFibonacci:%s\n", currentFibonacci);
			if (currentFibonacci <= high && currentFibonacci >= low) {
				listResult.add(currentFibonacci);
			}
		}

		Helper.print(listResult);
		return listResult.size();
	}

	static int fibonacci(int n) {
		if (0 == n) {
			return 0;
		}
		if (1 == n) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// static List<Integer> list = new ArrayList<Integer>();

	static int fibonacci2(int n, List<Integer> list) {
		int size = list.size();
		for (int i = size; i <= n; i++) {
			if (0 == n) {
				list.add(0, 0);
			} else if (1 == n) {
				list.add(1, 1);
			} else {
				list.add(n, list.get(n - 1) + list.get(n - 2));
			}
		}

		return list.get(n);
	}
}
