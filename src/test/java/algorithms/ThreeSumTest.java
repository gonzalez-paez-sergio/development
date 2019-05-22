package algorithms;

import edu.princeton.cs.algs4.In;
import org.junit.Assert;
import org.junit.Test;

public class ThreeSumTest {

  @Test
  public void test1Kints() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/1Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("test1Kints:" + result + ", time:" + time);
    Assert.assertEquals(70, result);
  }

  @Test
  public void test1KintsEnhanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/1Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test1KintsEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(70, result);
  }

  @Test
  public void test2Kints() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/2Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("test2Kints:" + result + ", time:" + time);
    Assert.assertEquals(528, result);
  }

  @Test
  public void test2KintsEnchanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/2Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test2KintsEnchanced:" + result + ", time:" + time);
    Assert.assertEquals(528, result);
  }

  @Test
  public void test4Kints() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/4Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("test4Kints:" + result + ", time:" + time);
    Assert.assertEquals(4039, result);
  }

  @Test
  public void test4KintsEnhanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/4Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test4KintsEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(4039, result);
  }

  @Test
  public void test4KintsEnhancedWithSortedArray() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/4Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhancedWithSortedArray(a);
    double time = timer.elapsedTime();
    System.out.println("test4KintsEnhancedWithSortedArray:" + result + ", time:" + time);
    Assert.assertEquals(12121, result);
  }

  @Test
  public void test10intsEnhancedWithSortedArray() {
    Stopwatch timer = new Stopwatch();
    int[] a = new int[] {5, 8, 3, 1, 3, 8, 8, 9, 0};
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhancedWithSortedArray(a);
    double time = timer.elapsedTime();
    System.out.println("test4KintsEnhancedWithSortedArray:" + result + ", time:" + time);
    Assert.assertEquals(0, result);
  }
}
