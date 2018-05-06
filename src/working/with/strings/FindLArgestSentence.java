package working.with.strings;

public class FindLArgestSentence {

	public static void main(String[] string) {

		System.out.println(solution("Forget  CVs..Save time . x x"));

		System.out.println(solution(null));
		System.out.println(solution("adfad.s fsadfas"));

		System.out.println(solution(null));
	}

	public static int solution(String string) {
		if (null == string) {
			return 0;
		}
		String[] stringArray = string.split("[.?!]");

		int max = 0;
		for (String stringItem : stringArray) {
			System.out.println("current sentence-" + stringItem);
			String[] stringArray2 = stringItem.split(" ");
			int intCounter = 0;
			for (String stringWord : stringArray2) {
				if (!stringWord.trim().equals("")) {
					intCounter++;
					System.out.printf("stringWord:%s, intCounter:%s\n", stringWord, intCounter);

				}

				if (intCounter > max) {
					max = intCounter;
				}
			}

		}
		return max;
	}
}