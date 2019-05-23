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
  public void test4KintsEnhancedEnhanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/4Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhancedEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test4KintsEnhancedEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(4039, result);
  }

  @Test
  public void test8Kints() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/8Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("test8KintsEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(32074, result);
  }

  @Test
  public void test8KintsEnhanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/8Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test8KintsEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(32074, result);
  }

  @Test
  public void test8KintsEnhancedEnhanced() {
    Stopwatch timer = new Stopwatch();
    int[] a = In.readInts("src/main/resources/algorithms/8Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.countEnhancedEnhanced(a);
    double time = timer.elapsedTime();
    System.out.println("test8KintsEnhanced:" + result + ", time:" + time);
    Assert.assertEquals(32074, result);
  }
}
