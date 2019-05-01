package working.with.strings;

/**
 * fix a function that takes an input as a string and outputs the input value as an integer
 *
 * @author sergiogp
 */
public class FixFunctionThatTakesAnInputAsStringAndOutputsTheInputValueAsNnInteger {

  /**
   * the string contains only numbers?
   *
   * @return
   */
  public static int strToInt(String str) {
    int i = 0;
    int num = 0;
    boolean isNeg = false;

    // Check for negative sign; if it's there, set the isNeg flag
    if (str.charAt(0) == '-') {
      isNeg = true;
      i = 1;
    }

    // Process each character of the string;
    while (i < str.length()) {
      num *= 10;
      num +=
          str.charAt(i++) - '0'; // Minus the ASCII code of '0' to get the value of the charAt(i++).
      System.out.printf("num=%d, char=%c\n", num, str.charAt(i - 1));
    }

    if (isNeg) num = -num;
    return num;
  }

  public static int strToInt1(String str) {
    int k = 0, result = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      result += (int) ((str.charAt(i) - '0') * Math.pow(10, k++));
    }

    return result;
  }
}
