package algorithms;

public class Percolation {
  private int size;
  private boolean[] grid;
  private WeightedUnionFind wuf;

  public Percolation(int n) {
    this.size = n;
    // create n-by-n grid, with all sites blocked
    this.grid = new boolean[n * n + 2];
    this.wuf = new WeightedUnionFind(n * n + 2);
  }

  public void open(int row, int col) { // open site (row, col) if it is not open already
    int pos = size * row + col;
    this.grid[pos] = true;
    connectOpenedN(row, col);
  }

  public void connectOpenedN(int row, int col) { // open site (row, col) if it is not open already
    if (row == 0) {
      this.connectTop(row, col);
    } else {
      this.connect(row, col, row - 1, col);
    }

    if (row == size - 1) {
      this.connectBottom(row, col);
    } else {
      this.connect(row, col, row + 1, col);
    }
    
    this.connect(row, col, row, col - 1);
    this.connect(row, col, row, col + 1);
  }

  public void connect(
      int row, int col, int row1, int col1) { // open site (row, col) if it is not open already
    if (0 <= row
        && row < size
        && 0 <= col
        && col < size
        && 0 <= row1
        && row1 < size
        && 0 <= col1
        && col1 < size
        && isOpen(row, col)
        && isOpen(row1, col1)) {
      int pos = size * row + col;
      int pos1 = size * row1 + col1;
      this.wuf.connect(pos, pos1);
    }
  }

  public void connectTop(int row, int col) { // open site (row, col) if it is not open already
    if (0 <= row && row < size && 0 <= col && col < size && isOpen(row, col)) {
      int pos = size * row + col;
      this.wuf.connect(pos, size * size);
    }
  }

  public void connectBottom(int row, int col) { // open site (row, col) if it is not open already
    if (0 <= row && row < size && 0 <= col && col < size && isOpen(row, col)) {
      int pos = size * row + col;
      this.wuf.connect(pos, size * size + 1);
    }
  }

  public boolean isOpen(int row, int col) { // is site (row, col) open?
    int pos = size * row + col;
    return this.grid[pos];
  }

  public boolean isFull(int row, int col) { // is site (row, col) full?
    int top = size * size;
    int pos = size * row + col;
    return wuf.connected(top, pos);
  }

  public int numberOfOpenSites() { // number of open sites
    return 0;
  }

  public boolean percolates() { // does the system percolate?
    int top = size * size;
    int bottom = size * size + 1;
    return wuf.connected(top, bottom);
  }

  public static void main(String[] args) { // test client (optional)
    Percolation percolation = new Percolation(3);
    percolation.open(0, 0);
    System.out.println(percolation.isFull(0, 0));
    percolation.open(1, 0);
    System.out.println(percolation.isFull(1, 0));
    percolation.open(2, 0);
    System.out.println(percolation.isFull(2, 0));
    System.out.println(percolation.percolates());
  }
}
