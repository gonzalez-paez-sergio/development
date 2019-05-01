package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * You are given a list(1-indexed) of size , initialized with zeroes. You have to perform operations
 * on the list and output the maximum of final values of all the elements in the list. For every
 * operation, you are given three integers , and and you have to add value to all the elements
 * ranging from index to (both inclusive).
 *
 * <p>For example, consider a list of size . The initial list would be = [, , ] and after performing
 * the update = , the new list would be = [, , ]. Here, we've added value 30 to elements between
 * indices 2 and 3. Note the index of the list starts from 1.
 *
 * <pre>
 *
 *
 *     0     0     0     0     0     0
 * 2 3 100
 *     0   100   100     0     0     0
 * 3 5 100
 *     0   100   200   100   100     0
 * 3 5 100
 *     0   100   200   200   200   100
 *     0   200   300   200   200   100
 *
 *
 *     0     0     0     0     0     0
 * 2 3 100
 *     0   100  -100     0     0     0
 * 3 5 100
 *     0   100   200     0  -100     0
 *
 *
 *
 * </pre>
 *
 * @author sergiogp
 */
public class ArrayManipulation {

  public static long arrayManipulationStream(int n, int[][] queries) {

    int[] output = new int[n + 1];
    IntStream.range(0, queries.length)
        .forEach(
            i -> {

              // System.out.println(i);
              // System.out.println("-" + queries.length);
              int a = queries[i][0];
              int b = queries[i][1];
              int k = queries[i][2];
              output[a] += k;
              if (b < n) {
                output[b + 1] -= k;
              }
            });

    long sum = 0;
    long max = 0;
    for (int i = 0; i < output.length; i++) {
      sum += output[i];
      max = Math.max(sum, max);
    }
    //
    // System.out.println("max:" + max);
    // AtomicLong sum1 = new AtomicLong(0);
    // //
    // System.out.print(LongStream.of(output).map(sum1::addAndGet).max());
    // final long max = 0;
    // long result = LongStream.of(output).map((long item) -> {
    // long sum = item;
    // ArrayManipulation.max = Math.max(sum, max);
    // return max;
    // }).max().getAsLong();

    return max;

    // in.close();

  }

  /*
   * Complete the arrayManipulation function below.
   */
  static int arrayManipulation(int n, int[][] queries) {
    // System.out.println(n);

    BigInteger[] intValues = construct(n + 1);
    BigInteger max = intValues[0];
    for (int i = 0; i < queries.length; i++) {
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        BigInteger bigInteger = intValues[j];
        intValues[j] = bigInteger.add(BigInteger.valueOf(queries[i][2]));
        if (max.compareTo(intValues[j]) < 0) {
          max = intValues[j];
        }
      }
      if (i % 10000 == 0) {
        System.out.printf("current index:%d, result:%s\n", i, max);
      }
      // printArray(intValues);
    }

    return max.intValue();
  }

  /*
   * Complete the arrayManipulation function below.
   */
  static long arrayManipulationLong(int n, int[][] queries) {
    // System.out.println(n);

    long[] intValues = new long[(n + 1)];
    long max = 0;

    // queries.

    for (int i = 0; i < queries.length; i++) {
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        // BigInteger bigInteger = intValues[j];
        intValues[j] += queries[i][2];
        if (max < intValues[j]) {
          max = intValues[j];
        }
      }

      if (i % 10000 == 0) {
        System.out.println("i:" + i);
      }
    }

    return max;
  }

  private static BigInteger[] construct(int n) {
    BigInteger[] intArray = new BigInteger[n];
    for (int i = 0; i < n; i++) {
      intArray[i] = BigInteger.valueOf(0);
    }
    return intArray;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./Destination.file"));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0].trim());

    int m = Integer.parseInt(nm[1].trim());

    int[][] queries = new int[m][3];

    for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");

      for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
        int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
        queries[queriesRowItr][queriesColumnItr] = queriesItem;
      }
    }

    // int n = 5;
    // int m = 3;
    // int[][] queries = new int[][] {
    //
    // { 1, 2, 100 },
    //
    // { 2, 3, 100 },
    //
    // { 3, 4, 100 }
    //
    // };

    long resultlong1 = arrayManipulationStream(n, queries);
    System.out.println("arrayManipulationStream:" + resultlong1);

    long resultlong = arrayManipulationLong(n, queries);
    System.out.println("arrayManipulationLong:" + resultlong);

    long resultlong11 = arrayManipulationLambda(n, queries);
    System.out.println("arrayManipulationLambda:" + resultlong11);

    bufferedWriter.write(String.valueOf(resultlong11));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }

  public static long arrayManipulationLambda(int n, int[][] queries) {
    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt();
    int m = queries.length;
    long[] output = new long[n];
    IntStream.range(0, m)
        .forEach(
            i -> {
              int a = queries[i][0];
              int b = queries[i][1] + 1;
              int k = queries[i][2];
              output[a] += k;
              if (b < n) output[b] -= k;
            });
    AtomicLong sum = new AtomicLong(0);
    return LongStream.of(output).map(sum::addAndGet).max().getAsLong();
  }

  // 2490686975 2490686975
}
