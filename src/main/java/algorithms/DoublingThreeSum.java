package algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingThreeSum {

  public void doubleTest() {
    double time = 0;
    for (int i = 1; time < 50; i += i) {
      time = timeTrial(i);
      StdOut.printf("%7d %5.1f\n", i, time);
    }
  }

  public double timeTrial(int size) {
    int MAX = 1000000;
    int[] a = new int[size];
    for (int i = 0; i < size; i++) a[i] = StdRandom.uniform(-MAX, MAX);
    Stopwatch timer = new Stopwatch();
    ThreeSum threeSum = new ThreeSum();
    int cnt = threeSum.count(a);
    return timer.elapsedTime();
  }
}
