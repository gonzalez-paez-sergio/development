package working.with.strings;

/**
 * find the minimum symmetrical number which is greater than the given number
 *
 * @author sergiogp
 */
public class SymmetricalNumbers {

  public static String findNextSymmetricalNumber(StringBuffer stringLine) {
    if (stringLine.length() == 0) {
      return null;
    }

    StringBuffer s1;
    int length = stringLine.length();
    int middle = length / 2;
    if (length % 2 == 0) {
      int intMiddle = Integer.parseInt(stringLine.substring(middle - 1, middle));
      s1 = new StringBuffer(stringLine.substring(0, middle));

      if (compare2strings(s1, new StringBuffer(stringLine.substring(middle)))) {
        s1.deleteCharAt(s1.length() - 1);
        s1.append(intMiddle + 1);
      }

      s1.append(new StringBuffer(s1).reverse());

    } else {
      int intMiddle = Integer.parseInt(stringLine.substring(middle, middle + 1));

      s1 = new StringBuffer(stringLine.substring(0, middle));

      if (compare2strings(s1, new StringBuffer(stringLine.substring(middle + 1)))) {
        intMiddle++;
      }
      StringBuffer s2 = new StringBuffer(s1).reverse();
      s1.append(intMiddle);
      s1.append(s2);
    }
    return s1.toString();
  }

  private static boolean compare2strings(StringBuffer s1, StringBuffer s2) {
    int i;
    for (i = s1.length() - 1; i >= 0; i--) {
      int p = Integer.parseInt(s1.substring(i, i + 1));
      int q = Integer.parseInt(s2.substring(s2.length() - 1 - i, s2.length() - i));

      if (q < p) {
        return false;
      }
      if (p < q) {
        return true;
      }
    }

    if (i < 0) {
      return true;
    }
    return false;
  }
}

//// Hit compile and run to see a sample output.
//// Read values from stdin, do NOT hard code input.
//
// import java.io.*;
// import java.util.*;
// import java.text.*;
// import java.math.*;
// import java.util.regex.*;
//
// class Solution {
// public static void main(String args[] ) throws Exception {
// String thisLine = null;
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// thisLine = br.readLine();
//
//
// int intline =
// Integer.parseInt(thisLine);
//
// int i =0 ;
// while ((thisLine = br.readLine()) != null && i++ < intline) {
// System.out.println(findNextSymmetricalNumber(thisLine.trim()));
// }
// }
//
// public static StringBuilder reverse (String string) {
// StringBuilder stringBuilder = new StringBuilder();
// for(int i=string.length()-1;i>=0;i--){
// stringBuilder.append(string.charAt(i));
// }
//
// return stringBuilder;
// }
//
// public static String findNextSymmetricalNumber(String stringNumber){
// if (stringNumber.trim() == "" || stringNumber.trim().length() ==0){
// return null;
// }
//
//
// String result = null;
// int length = stringNumber.length();
// if (length % 2 == 0){
// int m = length / 2;
// String stringMedium = stringNumber.substring(0,m);
// int newInt =
//// Integer.parseInt(stringMedium.substring(stringMedium.length()-1));
// for (int i = m-1; i >=0;i--){
// int p = Integer.parseInt(stringNumber.substring(i,i+1));
// int q = Integer.parseInt(stringNumber.substring(length-1-i,length-i));
// if (p==q){
// continue;
// }
// if (q<p) {
// break;
// }
// if (p<q){
// newInt++;
// break;
// }
// }
//
// stringMedium = stringMedium.substring(0,stringMedium.length()-1) + newInt;
//
//
//
// result = stringMedium + reverse(stringMedium);
//
// } else {
//
// int m = stringNumber.length()/2;
// String middle = stringNumber.substring( m,m+1);
// int newInt = Integer.parseInt (middle);
// newInt++;
//
// result = stringNumber.substring(0,m) + newInt +
//// reverse(stringNumber.substring(0,m));
// }
//
// return result;
// }
//
// public static boolean isSymmetricalNumber(String stringNumber){
// if (stringNumber.trim()=="" || stringNumber.trim().length() ==0){
// return false;
// }
// int i =0, j = stringNumber.length() -1;
//
// for ( ;i<j; i++, j--) {
// if (stringNumber.charAt(i) != stringNumber.charAt(j)){
// return false;
// }
// }
//
// //System.out.println(i + "-" + j);
//
//
// return true;
// }
// }
