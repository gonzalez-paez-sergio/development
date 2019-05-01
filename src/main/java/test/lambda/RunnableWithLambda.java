package test.lambda;

public class RunnableWithLambda {

  public static void main(String[] args) {

    (new Runnable() {
          public void run() {
            System.out.println("inside runnable");
          }
        })
        .run();

    (new Thread("Thread") {
          public void run() {
            System.out.println("inside thread w/run");
          }
        })
        .run();

    (new Thread("Thread") {
          public void run() {
            System.out.println("inside thread w/start");
          }
        })
        .start();

    // take care of the signature of the method to implement, if you add an
    // argument to the lambda expression you could break the whole function,
    // for example

    // Runnable runnable = (String string) -> System.out.println("inside
    // thread w/lambda" + string);
    Runnable runnable = () -> System.out.println("inside thread w/lambda");
    runnable.run();
  }
}
