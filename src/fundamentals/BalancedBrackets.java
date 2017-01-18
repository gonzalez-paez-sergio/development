package fundamentals;

import java.util.Scanner;

public class BalancedBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			System.out.println(evaluate(s) ? "YES" : "NO");
		}
	}

	static boolean evaluate(String string) {
		Stack<String> stack = new Stack(string.length());
		for (int i = 0; i < string.length(); i++) {
			String stringPopItem = null;
			String stringItem = string.substring(i, i + 1);
			// System.out.println(stringItem);
			if ("(".equals(stringItem))
				stack.push(stringItem);
			else if ("{".equals(stringItem))
				stack.push(stringItem);
			else if ("[".equals(stringItem))
				stack.push(stringItem);
			else if (")".equals(stringItem)) {
				stringPopItem = stack.pop();
				if (!"(".equals(stringPopItem)) {
					return false;
				}
			} else if ("}".equals(stringItem)) {
				stringPopItem = stack.pop();
				if (!"{".equals(stringPopItem)) {
					return false;
				}
			} else if ("]".equals(stringItem)) {
				stringPopItem = stack.pop();
				if (!"[".equals(stringPopItem)) {
					return false;
				}
			}
		}
		// at the end we need to be sure the stack is void
		return stack.isEmpty();
	}

}