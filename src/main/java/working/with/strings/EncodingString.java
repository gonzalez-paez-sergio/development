package working.with.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Write a program to encode a string in below format:
 *
 * <pre>
 * aabbcc => a2b3b4
 * aaa => a3
 * aabbaa => a2b2a2 //this expected use case eliminates the use of a hashtable
 * </pre>
 *
 * @author sergiogp
 */
class EncodingString {

  public static String encode(String string) {
    System.out.printf("string to encode:%s\n", string);

    if (null == string) {
      return null;
    }

    if ("".equals(string)) {
      return "";
    }

    char previousElement = string.charAt(0);
    int intCounter = 1;

    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 1; i < string.length(); i++) {
      // previous char equals current char
      System.out.printf(" previousElement=%s, currentChar=%s\n", previousElement, string.charAt(i));

      if (previousElement == string.charAt(i)) {
        System.out.printf("== previousElement=%c, i=%d\n", previousElement, i);
        intCounter++;
      } else {
        System.out.printf(
            "<> previousElement=%c, counter=%d, i=%d\n", previousElement, intCounter, i);
        stringBuffer.append(previousElement);
        stringBuffer.append(intCounter);
        intCounter = 1;
      }
      previousElement = string.charAt(i);
      System.out.printf("redefine the previousElement, new value=%s\n", previousElement);
    }
    System.out.printf("last counter value=%d\n", intCounter);
    stringBuffer.append(previousElement);
    stringBuffer.append(intCounter);
    return stringBuffer.toString();
  }

  @SuppressWarnings("unused")
  private static String format(int[][] arr) {
    System.out.println(arr);
    for (int i = 1; i < arr.length; i++) {
      System.out.printf("%s, %d", arr[i][0], arr[i][1]);
    }
    return null;
  }

  public static String encodeWithMap(String string) {
    Map<Character, Integer> hashtable = new LinkedHashMap<Character, Integer>();
    for (int i = 0; i < string.length(); i++) {
      char element = string.charAt(i);
      Integer integerValue = hashtable.get(element);
      // the element exists in the map
      if (null == integerValue) {
        integerValue = 1;
      } else {
        integerValue++;
      }
      hashtable.put(element, integerValue);
    }
    return format(hashtable);
  }

  public static String format(Map<Character, Integer> hashtable) {
    StringBuffer stringResult = new StringBuffer();

    for (char currentChar : hashtable.keySet()) {
      stringResult.append(currentChar);
      stringResult.append(hashtable.get(currentChar));
    }

    return stringResult.toString();
  }
}
