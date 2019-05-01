import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.io.*;

public class TestingJson {

  public static void main(String[] string) {
    TestingJson testingJson = new TestingJson();
    testingJson.test1();
  }

  private void test1() {
    try (BufferedReader variableJson =
        new BufferedReader(
            new InputStreamReader(getClass().getClassLoader().getResourceAsStream("test.json")))) {
      StringBuffer s = new StringBuffer();
      String string = null;
      while (null != (string = variableJson.readLine())) {
        s.append(string);
      }
      test(s.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void test(String variableJson) {
    DocumentContext s =
        JsonPath.parse(variableJson).read("$.channelResponse.AA/0574/DFW/LAX/2019-04-22");
    String s1 = s.read("$.topicId");
    System.out.println(s1);
  }
}
