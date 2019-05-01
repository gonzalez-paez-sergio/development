package callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * * Simple Java program to demonstrate how to use Callable and Future class in * Java. You can use
 * FutureTask for asynchronous processing. * * @author WINDOWS 8 *
 */
public class HelloWorldApp {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    // creating thread pool to execute task which implements Callable
    ExecutorService es = Executors.newSingleThreadExecutor();
    System.out.println("submitted callable task to calculate factorial of 10");
    Future<Long> result10 = es.submit(new FactorialCalculator(10));
    System.out.println("submitted callable task to calculate factorial of 15");
    Future<Long> result15 = es.submit(new FactorialCalculator(15));
    System.out.println("submitted callable task to calculate factorial of 20");
    Future<Long> result20 = es.submit(new FactorialCalculator(20));
    System.out.println("Calling get method of Future to fetch result of factorial 10");
    Future<Long> result25 = es.submit(new FactorialCalculator(25));
    System.out.println("submitted callable task to calculate factorial of 25");
    Future<Long> result35 = es.submit(new FactorialCalculator(35));
    System.out.println("submitted callable task to calculate factorial of 40");
    Future<Long> result40 = es.submit(new FactorialCalculator(40));
    System.out.println("Calling get method of Future to fetch result of factorial 10");
    Long factorialof10 = result10.get();
    System.out.println("factorial of 10 is : " + factorialof10);
    System.out.println("Calling get method of Future to get result of factorial 15");
    Long factorialof15 = result15.get();
    System.out.println("factorial of 15 is : " + factorialof15);
    System.out.println("Calling get method of Future to get result of factorial 20");
    Long factorialof20 = result20.get();
    System.out.println("factorial of 20 is : " + factorialof20);
    Long factorialof25 = result25.get();
    System.out.println("factorial of 25 is : " + factorialof25);
    System.out.println("Calling get method of Future to get result of factorial 35");
    Long factorialof35 = result35.get();
    System.out.println("factorial of 35 is : " + factorialof35);
    System.out.println("Calling get method of Future to get result of factorial 40");
    Long factorialof40 = result40.get();
    System.out.println("factorial of 40 is : " + factorialof40);
  }
}

class FactorialCalculator implements Callable<Long> {
  private int number;

  public FactorialCalculator(int number) {
    this.number = number;
  }

  @Override
  public Long call() throws Exception {
    return factorial(number);
  }

  private long factorial(int n) throws InterruptedException {
    long result = 1;
    while (n != 0) {
      result = n * result;
      n = n - 1;
      Thread.sleep(100);
    }
    return result;
  }
}

// wipro
// houston texas
// petroleeum

// Read more:
// http://javarevisited.blogspot.com/2015/06/how-to-use-callable-and-future-in-java.html#ixzz5AVWppCmD
