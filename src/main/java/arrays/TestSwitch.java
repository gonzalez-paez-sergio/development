package arrays;

import java.util.UUID;

public class TestSwitch {
  public static void main(String[] string) {

    System.out.println("test");

    String s1 = new String("ABC");
    String s2 = new String("ABC");
    String s3 = s2;

    System.out.println(s1 == s2);
    System.out.println(s3 == s2);

    String s4 = "ABC";
    String s5 = "ABC";

    System.out.println(s4 == s5);

    String stringSwitch = "holaasdfadsWWWWrwww";
    switch (stringSwitch) {
      case "string":
        System.out.println("case 1");
        break;
      case "hola":
        System.out.println("case hola");
        break;
      default:
        System.out.println("default");
        break;
    }

    byte[] b = stringSwitch.getBytes();
    System.out.println(b.length);

    int intCounter = 0;
    while (!stringSwitch.equals("")) {
      stringSwitch = stringSwitch.substring(1);
      intCounter++;
    }
    System.out.printf("inCounter:%s", intCounter);
    // si en cualquier version pero al menos en la 8 esta
    String uuid = UUID.randomUUID().toString();

    System.out.println(uuid);
  }
}
