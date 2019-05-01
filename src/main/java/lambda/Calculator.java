package lambda;

/**
 * create a calculator
 *
 * @author sergiogp
 */
public class Calculator {
  public static void main(String[] args) {

    //		Calculate<String> sumString = (a, b) -> a + b;

    Calculate<Integer> sum = (a, b) -> a + b;
    Calculate<Integer> difference = (a, b) -> a - b;
    Calculate<Integer> divide =
        (a, b) -> {
          if (b != 0) return a / b;
          else return 0;
        };
    Calculate<Integer> module =
        (a, b) -> {
          if (b != 0) return a % b;
          else return 0;
        };

    int f = calculate(4, 6, sum);
    System.out.printf("sum:%d\n", f);

    f = calculate(4, 6, difference);
    System.out.printf("difference:%d\n", f);

    f = calculate(4, 6, divide);
    System.out.printf("divide:%s\n", f);

    f = calculate(4, 0, module);
    System.out.printf("Module:%s\n", f);
  }

  public static int calculate(int a, int b, Calculate<Integer> calc) {
    return calc.operate(a, b);
  }

  interface Calculate<K extends Number> {
    public int operate(K k1, K k2);
  }
}
