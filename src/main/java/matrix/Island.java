package matrix;

public class Island {

  public static void main(String[] string) {
    Island island = new Island();
    int[][] grid =
        new int[][] {
          {1, 1, 1, 1, 1},
          {0, 1, 0, 0, 1},
          {1, 1, 0, 1, 1},
          {0, 0, 0, 0, 0},
          {0, 0, 1, 1, 0}
        };

    //    int[][] result = new int[grid.length][grid[0].length];
    // island.recursiveTest(grid, 0, 0, result,0);
    island.iterativeTest1(grid);
    // island.printMatrix(result);
  }

  public boolean isLandAndIsInsideGrid(int[][] grid, int i, int j, int[][] result) {
    return 0 <= i
        && i < grid.length
        && 0 <= j
        && j < grid[i].length
        // current position is land
        && grid[i][j] == 1
        // this is a new position
        && result[i][j] == 0;
  }

  public void iterativeTest1(int[][] grid, int i, int j, int[][] result) {
    result[i][j] = 1;
    if (isLandAndIsInsideGrid(grid, i - 1, j, result)) {
      iterativeTest1(grid, i - 1, j, result);
    }
    if (isLandAndIsInsideGrid(grid, i + 1, j, result)) {
      iterativeTest1(grid, i + 1, j, result);
    }
    if (isLandAndIsInsideGrid(grid, i, j - 1, result)) {
      iterativeTest1(grid, i, j - 1, result);
    }
    if (isLandAndIsInsideGrid(grid, i, j + 1, result)) {
      iterativeTest1(grid, i, j + 1, result);
    }

    // this scenarios are not neccessary....
    // if (isLandAndIsInsideGrid(grid, i - 1, j - 1, result)) {
    //   iterativeTest1(grid, i - 1, j - 1, result);
    // }
    // if (isLandAndIsInsideGrid(grid, i + 1, j + 1, result)) {
    //   iterativeTest1(grid, i + 1, j + 1, result);
    // }
    // if (isLandAndIsInsideGrid(grid, i + 1, j - 1, result)) {
    //   iterativeTest1(grid, i + 1, j - 1, result);
    // }
    // if (isLandAndIsInsideGrid(grid, i - 1, j + 1, result)) {
    //   iterativeTest1(grid, i - 1, j + 1, result);
    // }
  }

  public int iterativeTest1(int[][] grid) {
    int counter = 0;
    int[][] result = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1 && result[i][j] == 0) {
          iterativeTest1(grid, i, j, result);
          counter++;
        }
      }
    }
    return counter;
  }

  public void iterativeTest(int[][] grid, int[][] result) {
    int counter = 1;
    for (int i = 0; i < grid.length; i++) {
      System.out.printf("result=%s, i=%d\n", result[i], i);

      printMatrix(result);
      for (int j = 0; j < grid[i].length; j++) {
        if (1 == grid[i][j]) {
          if (newIsland(grid, i, j, counter)) {
            counter++;
          }
          result[i][j] = counter;
        }
      }
    }
  }

  boolean newIsland(int[][] grid, int i, int j, int counter) {
    if (i > 0 && 1 == grid[i - 1][j]) {
      return false;
    }
    if (j > 0 && 1 == grid[i][j - 1]) {
      return false;
    }
    if (i + 1 < grid.length && 1 == grid[i + 1][j]) {
      return false;
    }
    if (j + 1 < grid[i].length && 1 == grid[i][j + 1]) {
      return false;
    }
    return true;
  }

  public int recursiveTest(int[][] grid, int i, int j, int[][] result, int counter) {
    System.out.printf("grid=%d, i=%d, j=%d\n", grid[i][j], i, j);
    // if(0!=result[i][j]){
    // we do not want to visit the same location 2 times
    // return counter;
    //  }

    boolean r = amIInAnIsland(grid, i, j);
    if (!r) {
      counter++;
    }

    if (1 == grid[i][j]) {
      // && 0==grid[i+1][j]&& 0==grid[i][j+1]){
      result[i][j] = counter;
    }
    if (i + 1 < grid.length) {
      recursiveTest(grid, i + 1, j, result, counter);
    }
    if (j + 1 < grid[i].length) {
      recursiveTest(grid, i, j + 1, result, counter);
    }
    return counter;
  }

  boolean amIInAnIsland(int[][] grid, int i, int j) {
    if (i == 0 && j == 0 && 1 == grid[i][j]) {
      return true;
    }
    if (1 == grid[i][j]) {
      if (i > 0 && 1 == grid[i - 1][j] || j > 0 && 1 == grid[i][j - 1]) {
        return true;
      }
    }
    return false;
  }

  boolean amIInAnIsland1(int[][] grid, int i, int j) {
    if (i == 0 && j == 0 && 0 == grid[i][j]) {
      return false;
    }
    if (0 == grid[i][j]) {
      if (i > 0 && 1 == grid[i - 1][j] || j > 0 && 1 == grid[i][j - 1]) {
        return false;
      }
    }
    return true;
  }

  public void printMatrix(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        System.out.print(" " + grid[i][j]);
      }

      System.out.println();
    }
  }
}
