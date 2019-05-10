package algorithms;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private Percolation percolation;
  private int trials;
  private int size;
  private double[] threshold;

  public PercolationStats(
      int size, int trials) { // perform trials independent experiments on an n-by-n grid
    this.trials = trials;
    this.threshold = new double[trials];
    this.size = size;
    this.percolation = new Percolation(size);
  }

  public double mean() { // sample mean of percolation threshold
    return StdStats.mean(this.threshold);
    // return this.mean / this.trials;
  }

  public double stddev() { // sample standard deviation of
    return StdStats.stddev(this.threshold);
  } // percolation
  // threshold
  public double confidenceLo() { // low  endpoint of 95% confidence interval
    return (double) StdStats.mean(this.threshold)
        - 1.96 * StdStats.stddev(this.threshold) / Math.sqrt(this.trials);
  }

  public double confidenceHi() { // high endpoint of 95% confidence
    return (double) StdStats.mean(this.threshold)
        + 1.96 * StdStats.stddev(this.threshold) / Math.sqrt(this.trials);
  } // interval

  public static void main(String[] args) { // test client (described below)
    int size = 20;
    int trials = 1000;
    PercolationStats percolationStats = new PercolationStats(size, trials);
    percolationStats.test();
    System.out.printf("mean: %2.15f \n", percolationStats.mean());
    System.out.printf("stddev: %2.15f \n", percolationStats.stddev());
    System.out.printf(
        "95 confidence interval = [%2.15f, %2.15f]\n",
        percolationStats.confidenceLo(), percolationStats.confidenceHi());
  }

  private void test() {
    int i = 0;
    while (i < this.trials) {
      this.threshold[i] = this.test(this.size);
      // this.mean += this.threshold[i];
      i++;
    }
  }

  private double test(int size) {
    while (!percolation.percolates()) {
      int row = StdRandom.uniform(0, size);
      int col = StdRandom.uniform(0, size);
      percolation.open(row, col);
      // System.out.println(
      //     "number of open sites ["
      //         + percolation.numberOfOpenSites()
      //         + "]["
      //         + (percolation.numberOfOpenSites() * 100) / (size * size)
      //         + "]");
    }
    // System.out.println(
    // "number of open sites [" + percolation.numberOfOpenSites() + "][" + threshold + "]");
    return (double) percolation.numberOfOpenSites() / (size * size);
  }
}
