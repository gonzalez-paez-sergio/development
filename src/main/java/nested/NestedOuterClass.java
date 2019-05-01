package nested;

public class NestedOuterClass {

  private static final int privateStaticFinal = 18;
  public static final int publicStaticFinal = 0;
  private static int privateStatic = 18;
  public static int publicStatic = 0;
  private final int privateFinal = 0;
  public final int publicFinal = 0;
  private int privateInt = 0;
  public int publicInt = 0;

  public static String parentStaticMethod() {
    return "\n\tinside staticMethod()";
  }

  public String parentNonStaticMethod() {
    return "\n\tinside nonStaticMethod()";
  }

  static class StaticNestedInnerClass {

    // ok , we can define a static variable
    static int testingStaticVariablesInteger;

    public void method() {
      // we can access only to the static variables, public and private
      System.out.println(
          "StaticNestedInnerClass.method "
              + "\n\tprivateStaticFinal:"
              + privateStaticFinal
              + "\n\tpublicStaticFinal:"
              + publicStaticFinal
              + "\n\tprivateStatic:"
              + privateStatic++
              + "\n\tpublicStaticl:"
              + publicStatic++
              + parentStaticMethod()
          // + parentNonStaticMethod()//non permitted

          );
    }

    // ok , we can define a static method
    public static void staticMethod() {
      // we can access only to the static variables, public and private
      System.out.println(
          "StaticNestedInnerClass.staticMethod "
              + "\n\tprivateStaticFinal:"
              + privateStaticFinal
              + "\n\tpublicStaticFinal:"
              + publicStaticFinal
              + "\n\tprivateStatic:"
              + privateStatic++
              + "\n\tpublicStaticl:"
              + publicStatic++
              + parentStaticMethod()
          // + parentNonStaticMethod()//non permitted

          );
    }
  }

  public class NestedInnerClass {

    // we can not define static variables or methods inside this class
    // as this is non static
    // static int testingStaticVariablesInteger;

    public void method() {
      // we can access only to the static variables, public and private
      System.out.println(
          "NestedInnerClass.method "
              + "\n\tprivateStaticFinal:"
              + privateStaticFinal
              + "\n\tpublicStaticFinal:"
              + publicStaticFinal
              + "\n\tprivateStatic:"
              + privateStatic++
              + "\n\tpublicStaticl:"
              + publicStatic++
              + "\n\tprivateFinal:"
              + privateFinal
              + "\n\tpublicFinal:"
              + publicFinal
              + "\n\tprivateInt:"
              + privateInt++
              + "\n\tpublicInt:"
              + publicInt++
              + parentStaticMethod()
              + parentNonStaticMethod());
    }

    public void method(StaticNestedInnerInterface staticNestedInnerInterface) {
      System.out.println(
          "INSIDE METHOD StaticNestedInnerInterface:"
              + staticNestedInnerInterface.getStringFromInterface());
    }

    // you can not declare a static method inside a inner non static class
    // public static void staticMethod() {
    // // we can access only to the static variables, public and private
    // System.out.println(
    // "method" + privateStaticFinal + "-" + publicStaticFinal + "-" + privateStatic
    // + "-" + publicStatic);
    // }
  }

  static interface StaticNestedInnerInterface {
    public String getStringFromInterface();
  }

  public static void main(String... strings) {
    NestedOuterClass.StaticNestedInnerClass inner = new NestedOuterClass.StaticNestedInnerClass();
    inner.method();

    StaticNestedInnerClass.staticMethod();
    NestedInnerClass nestedInnerClass = new NestedOuterClass().new NestedInnerClass();

    nestedInnerClass.method();
    nestedInnerClass.method(
        new NestedOuterClass.StaticNestedInnerInterface() {

          @Override
          public String getStringFromInterface() {
            // TODO Auto-generated method stub
            return "this is the string from the anonymous class";
          };
        });
  }
}
