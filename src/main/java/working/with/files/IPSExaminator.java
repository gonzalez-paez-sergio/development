package working.with.files;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Examine apache log file and find out IP which has hit more number of times
 *
 * <p>given: Log file was given in the form of array in which each record of array was representing
 * one line for log file
 *
 * <p>Sample log entry
 *
 * <pre>
 * 10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * 10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * 10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * 10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * 10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * 10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP
 * </pre>
 *
 * @author sergiogp
 */
public class IPSExaminator {

  public static String countLinesByIP(String[] string) {

    if (null == string) {
      return null;
    }
    Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    String stringIPMax = null;
    Integer intMax = 0;
    for (String strintItem : string) {
      if (null == strintItem || "".equals(strintItem)) {
        continue;
      }
      String stringIP = parse(strintItem);
      Integer integer = map.get(stringIP);
      integer = integer == null ? 1 : ++integer;
      map.put(stringIP, integer);
      if (integer > intMax) {
        stringIPMax = stringIP;
        intMax = integer;
      }
    }
    return null == stringIPMax ? null : stringIPMax + "-" + intMax;
  }

  public static String parse(String stringLine) {
    String[] stringSplitted = stringLine.split(" ");
    return stringSplitted[0];
  }
}
