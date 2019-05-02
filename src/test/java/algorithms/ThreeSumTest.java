package algorithms;

import edu.princeton.cs.algs4.In;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ThreeSumTest {

  Stopwatch timer;
  ThreeSum threeSum;

  @Before
  public void setup() {
    timer = new Stopwatch();
    threeSum = new ThreeSum();
  }

  @Test
  public void test1Kints() {
    int[] a = In.readInts("resources/algorithms/1Kints.txt");
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("number of 3-ples:" + result + ", time:" + time);
    Assert.assertEquals(70, result);
  }

  @Test
  public void test2Kints() {
    int[] a = In.readInts("resources/algorithms/2Kints.txt");
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("number of 3-ples:" + result + ", time:" + time);
    Assert.assertEquals(528, result);
  }

  @Test
  public void test4Kints() {
    int[] a = In.readInts("resources/algorithms/4Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("number of 3-ples:" + result + ", time:" + time);
    Assert.assertEquals(4039, result);
  }

  @Test
  public void test8Kints() {
    int[] a = In.readInts("resources/algorithms/8Kints.txt");
    ThreeSum threeSum = new ThreeSum();
    int result = threeSum.count(a);
    double time = timer.elapsedTime();
    System.out.println("number of 3-ples:" + result + ", time:" + time);
    Assert.assertEquals(32074, result);
  }
}
