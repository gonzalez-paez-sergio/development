package cardinal.health;

public class GameOfLife2 {

  private int rowCount;
  private int columnCount;
  private int[][] currentGeneration;
  private int[][] nextGeneration;

  public GameOfLife2(int rowCount, int columnCount) {
    this.currentGeneration = new int[rowCount][columnCount];
    this.rowCount = currentGeneration.length;
    this.columnCount = currentGeneration[0].length;
  }

  void print(int[][] grid, String string) {
    System.out.println(string);
    for (int i = 0; i < this.rowCount; i++) {
      for (int j = 0; j < this.columnCount; j++) {
        System.out.print(grid[i][j] == 0 ? "." : "*");
      }
      // new line for every row
      System.out.println();
    }
    System.out.println();
  }

  // Function to calculate the next generation
  void nextGeneration() {
    print(this.currentGeneration, "Current  Generation");
    this.nextGeneration = new int[currentGeneration.length][currentGeneration[0].length];

    // do not consider the edges of the matrix, there is no option for life there,
    // so even if the original matrix has some alive cells in an edge, the
    // respective position in the new generation will be turned off
    for (int i = 1; i < this.rowCount - 1; i++) {
      for (int j = 1; j < this.columnCount - 1; j++) {

        // calculate the alive neighbors for every entry
        int aliveNeighbors = aliveNeighbors(currentGeneration, i, j);

        if ((aliveNeighbors < 2) || (aliveNeighbors > 3)) {
          nextGeneration[i][j] = 0;
        } else if ((currentGeneration[i][j] == 0) && (aliveNeighbors == 3)) {
          nextGeneration[i][j] = 1;
        } else {
          nextGeneration[i][j] = currentGeneration[i][j];
        }
      }
    }

    print(this.nextGeneration, "Next Generation");
  }

  private int aliveNeighbors(int[][] grid, int l, int m) {
    int aliveNeighbours = 0;
    // 8 possible alive neighbors
    aliveNeighbours += grid[l - 1][m - 1];
    aliveNeighbours += grid[l - 1][m];
    aliveNeighbours += grid[l - 1][m + 1];
    aliveNeighbours += grid[l][m - 1];
    aliveNeighbours += grid[l][m + 1];
    aliveNeighbours += grid[l + 1][m - 1];
    aliveNeighbours += grid[l + 1][m];
    aliveNeighbours += grid[l + 1][m + 1];

    return aliveNeighbours;
  }

  /**
   * helper for testing purposes
   *
   * @param i
   * @param j
   */
  public void setLivingCell(int i, int j) {
    currentGeneration[i][j] = 1;
  }

  /** @return the currentGeneration */
  public int[][] getCurrentGeneration() {
    return currentGeneration;
  }

  /** @return the nextGeneration */
  public int[][] getNextGeneration() {
    return nextGeneration;
  }
}
