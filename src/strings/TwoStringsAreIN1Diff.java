

package strings;

public class TwoStringsAreIN1Diff {


  public static void main (String[] args) {
    String a = "sergio";
    String b = "ser1gio";

    boolean result = verify(a, b);
    System.out.println(result);
    System.out.println();

    a = "sergio6";
    b = "1sergio";

    result = verify(a, b);
    System.out.println(result);
    System.out.println();

        a = "1";
    b = "2";

    result = verify(a, b);
    System.out.println(result);
    System.out.println();


    a = "SERGIO";
    b = "1sergio";

    result = verify(a, b);
    System.out.println(result);
    System.out.println();

    a = "sergio";
    b = "1sergio";

    result = verify(a, b);
    System.out.println(result);
    System.out.println();
    a = "sergio";
    b = "sergio1";

    result = verify(a, b);
    System.out.println(result);
    System.out.println();
  }


  public static boolean verify(String a, String b) {
    return verify1(a, b) || verify1(b,a);
  }

  public static boolean verify1(String a, String b){
    int la =a.length();
    int lb =b.length();
    if (Math.abs(la-lb)>1) {
      return false;
    }

    int i=0,j=0,ca=-1,cb=-1;
    while (Math.abs(i-j)<=1) {
      if (i<la){
        ca = a.charAt(i);
      }
      if (j<lb){
        cb = b.charAt(j);
      }
      if (i == la-1 && j == lb-1){
        return true;
      }
      System.out.println("i:"+i+", a:"+(char)ca+", j:"+j+", b:" + (char)cb);
      if (ca < cb){
        //VALIDATE NEXT CHAR AT B
        j--;
      } else if (ca > cb){
        //VALIDATE NEXT CHAR AT B
        i--;
      }
      i++;
      j++;
    }
    System.out.println("return i:"+i+", a:"+ca+", j:"+j+", b:" + cb);
    return false;
  }
}
