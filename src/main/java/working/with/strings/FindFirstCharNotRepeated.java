package working.with.strings;

/** Given sample alphanumerical string, find the first character that does not repeat on string */
public class FindFirstCharNotRepeated {

  public static char test1(String stringToAnal) {
    int intCurrent = 1;

    System.out.printf("string to analize: %s\n", stringToAnal);

    stringToAnal = stringToAnal.concat("-");
    /*
     * ading a char nor allowed in the end will help us to handle the case in chich
     * the element is on the last position
     */

    for (int i = 1; stringToAnal.length() > i; i++) {
      char previous = stringToAnal.charAt(i - 1);
      char current = stringToAnal.charAt(i);
      if (previous == current) {
        intCurrent++;
        // System.out.printf("equals: previous: %s, current: %s\n", previous, current);
      } else {
        if (intCurrent == 1) {
          /// System.out.printf("result: previous: %s, current: %s\n", previous, current);
          return previous;
        }
        // System.out.printf("different: previous: %s, current: %s, reseting the current
        // counter: %d\n", previous,
        // current, intCurrent);
        intCurrent = 1;
      }
    }
    return '0';
  }
}
