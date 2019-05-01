package arrays;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculatingMediaAndAverage {

  public static void main(String[] stringjj) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 9, 7, 10, 11, 16};
    CalculatingMediaAndAverage calculatingMediaAndAverage = new CalculatingMediaAndAverage();
    float intResutl = calculatingMediaAndAverage.getMean(arr);
    System.out.printf("intResutl:%f\n", intResutl);
    System.out.println(intResutl);

    intResutl = calculatingMediaAndAverage.getAverage(arr);
    System.out.printf("intResutl:%f\n", intResutl);
    System.out.println(intResutl);

    /////////////////////////
    Mean mean = calculatingMediaAndAverage.new Mean(arr);
    Average average = calculatingMediaAndAverage.new Average(arr);

    ExecutorService executorService = Executors.newCachedThreadPool();

    Future<Float> futureMean = executorService.submit(mean);
    Future<Float> futureAverage = executorService.submit(average);

    try {
      System.out.println("mean:   " + futureMean.get());
      System.out.println("average:" + futureAverage.get());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public float getMean(int[] arr) {
    Arrays.sort(arr);
    if (0 == arr.length % 2) {
      int middle = Math.floorDiv(arr.length, 2);
      return (float) (arr[middle] + arr[middle - 1]) / 2;
    } else {
      return arr[Math.floorDiv(arr.length, 2)];
    }
  }

  public float getAverage(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return (float) sum / arr.length;
  }

  ///////////////////
  ///////////////////

  class Mean implements Callable<Float> {
    int[] arr;

    public Mean(int[] arr) {
      this.arr = arr;
    }

    @Override
    public Float call() throws Exception {

      return getMean(arr);
    }

    private float getMean(int[] arr) throws InterruptedException {
      Arrays.sort(arr);
      int seconds = (arr.length % 2) * 1000;
      System.out.printf("%s - waiting %s seconds\n", getClass(), seconds);
      Thread.sleep(seconds);
      if (0 == arr.length % 2) {
        int middle = Math.floorDiv(arr.length, 2);

        seconds = middle * 1000;
        System.out.printf("%s - waiting %s seconds\n", getClass(), seconds);
        Thread.sleep(seconds);

        return (float) (arr[middle] + arr[middle - 1]) / 2;
      } else {

        seconds = Math.floorDiv(arr.length, 2) * 1000;
        System.out.printf("%s - waiting %s seconds\n", getClass(), seconds);
        Thread.sleep(seconds);

        return arr[Math.floorDiv(arr.length, 2)];
      }
    }
  }

  class Average implements Callable<Float> {

    private int[] arr;

    public Average(int[] arr) {
      this.arr = arr;
    }

    @Override
    public Float call() throws InterruptedException {
      int sum = 0;
      for (int i = 0; i < this.arr.length; i++) {
        int seconds = arr[i] * 1000;
        System.out.printf("%s - waiting %s seconds\n", getClass(), seconds);
        Thread.sleep(seconds);
        sum += arr[i];
      }
      System.out.printf("sum:%s\n", sum);
      return (float) sum / this.arr.length;
    }
  }
}
