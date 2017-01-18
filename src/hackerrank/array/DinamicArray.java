package hackerrank.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DinamicArray {
	static int lastAns = 0;
	static int N;
	static int Q;
	static List<Integer>[] seqList;
	static int[] intSize = new int[10];

	public static void findSequence1(int x, int y) {
		int intSeq = (x ^ lastAns) % N;
		seqList[intSeq].add(y);
	}

	public static void findSequence2(int x, int y) {
		int intSeq = (x ^ lastAns) % N;
		lastAns = seqList[intSeq].get(y % (seqList[intSeq].size()));
		System.out.println(lastAns);
	}

	public static void evaluate(String stringLine) {
		String[] stringArray = stringLine.split(" ");
		String stringOperation = stringArray[0];
		if (stringOperation.equals("1")) {
			findSequence1(Integer.parseInt(stringArray[1]),
					Integer.parseInt(stringArray[2]));
		}
		if (stringOperation.equals("2")) {
			findSequence2(Integer.parseInt(stringArray[1]),
					Integer.parseInt(stringArray[2]));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		Q = in.nextInt();
		seqList = new List[N];
		for (int i = 0; i < N; i++) {
			seqList[i] = new ArrayList<Integer>();
		}

		// System.out.printf("N=%d, Q=%d\n",N,Q);
		for (int i = 0; i <= Q; i++) {
			String s = in.nextLine();
			evaluate(s);
		}
	}
}