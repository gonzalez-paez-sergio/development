package matrix;

import org.junit.Assert;
import org.junit.Test;

public class IslandTest {

  @Test
  public void iterativeTest1Test() {
    Island island = new Island();
    int[][] grid =
        new int[][] {
          {1, 1, 1, 1, 1},
          {0, 1, 0, 0, 1},
          {1, 1, 0, 1, 1},
          {0, 0, 0, 0, 0},
          {0, 0, 1, 1, 0}
        };

    int counter = island.iterativeTest1(grid);
    System.out.printf("counter=%s\n", counter);
    Assert.assertEquals(2, counter);
  }

  @Test
  public void iterativeTest1Test1() {
    Island island = new Island();
    int[][] grid =
        new int[][] {
          {1, 1, 0, 1, 1},
          {0, 0, 0, 0, 1},
          {1, 1, 0, 1, 1},
          {0, 0, 0, 0, 0},
          {0, 0, 1, 1, 0}
        };

    int counter = island.iterativeTest1(grid);
    System.out.printf("counter=%s\n", counter);
    Assert.assertEquals(4, counter);
  }

  @Test
  public void iterativeTest1Test2() {
    Island island = new Island();
    int[][] grid =
        new int[][] {
          {1, 1, 1, 1, 1},
          {0, 0, 0, 0, 1},
          {1, 1, 0, 1, 1},
          {0, 0, 0, 0, 1},
          {1, 0, 1, 1, 0}
        };

    int counter = island.iterativeTest1(grid);
    System.out.printf("counter=%s\n", counter);
    Assert.assertEquals(4, counter);
  }
}
