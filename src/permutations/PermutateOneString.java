package permutations;

public class PermutateOneString {

	public static void main(String[] string) {

		String stringT = "ABCd";

		permutate("", stringT);
	}

	static void permutate(String stringPrefix, String string) {

		int n = string.length();
//		System.out.printf("-%d, %s, %s\n", n, stringPrefix, string);

		if (string.length() == 0) {
			System.out.printf("*%d, %s, %s\n", n, stringPrefix, string);

		} else {
			for (int i = 0; i < string.length(); i++) {
				char stringC = string.charAt(i);
				String stringD = string.substring(0, i) + string.substring(i + 1, string.length());

//				System.out.printf("+%d, %s, %s\n", n, stringC, stringD);
				permutate(stringPrefix + stringC, stringD);

			}
		}
	}
}
