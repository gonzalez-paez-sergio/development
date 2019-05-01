package arrays.fibonacci;

import java.math.BigInteger;

public class SixLessSignificantDigitsOnFibonacciNumber {

  public static void main(String[] string) {
    Fibonacci fibonacci = new Fibonacci();

    BigInteger m = BigInteger.valueOf(100000);

    BigInteger i = fibonacci.calculate(8);
    // System.out.println(i);
    i = i.mod(m);
    System.out.println(i);

    i = fibonacci.calculate(35);
    // System.out.println(i);
    i = i.mod(m);
    System.out.println(i);

    i = fibonacci.calculate(355);
    // System.out.println(i);
    i = i.mod(m);
    System.out.println(i);

    i = fibonacci.calculate(3551);
    // System.out.println(i);
    i = i.mod(m);
    System.out.println(i);

    // BigDecimal bd2 = toSignificantFigures(BigDecimal.valueOf(4.12345), 4);
    //// BigDecimal bd3 = toSignificantFigures(BigDecimal.valueOf(1234.345), 4);
    //// BigDecimal bd4 = toSignificantFigures(BigDecimal.valueOf(0.000003599999),
    // 4);
    ////
    //// System.out.println("bd2: " + String.format("%f", bd2));
    //// System.out.println("bd3: " + String.format("%f", bd3));
    //// System.out.println("bd4: " + String.format("%f", bd4));
  }

  // public static BigDecimal toSignificantFigures(BigDecimal bd, int
  // significantFigures) {
  // String s = String.format("%." + significantFigures + "G", bd);
  // BigDecimal result = new BigDecimal(s);
  // return result;
  // }
  //
  // BigInteger

}
