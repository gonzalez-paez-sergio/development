package cardinal.health;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class TestGameOfLife2 {

  private GameOfLife2 gameOfLife;

  @Before
  public void before() {
    gameOfLife = new GameOfLife2(4, 8);
  }

  @Test
  public void testExampleGiven() {
    /**
     * Current Generation
     *
     * <pre>
     * ........
     * ....*...
     * ...**...
     * ........
     * </pre>
     */
    gameOfLife.setLivingCell(1, 4);
    gameOfLife.setLivingCell(2, 3);
    gameOfLife.setLivingCell(2, 4);

    /**
     * Next Generation
     *
     * <pre>
     * ........
     * ...**...
     * ...**...
     * ........
     * </pre>
     */
    gameOfLife.nextGeneration();

    int[][] local =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 1, 0, 0, 0},
          {0, 0, 0, 1, 1, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };

    assertEquals(Arrays.deepEquals(gameOfLife.getNextGeneration(), local), true);
  }

  @Test
  public void testEdgeCells() {
    /**
     * Current Generation
     *
     * <pre>
     * ........
     * ....*...
     * ...**.**
     * .......*
     * </pre>
     */
    gameOfLife.setLivingCell(1, 4);
    gameOfLife.setLivingCell(2, 3);
    gameOfLife.setLivingCell(2, 4);
    gameOfLife.setLivingCell(2, 6);
    gameOfLife.setLivingCell(2, 7);
    gameOfLife.setLivingCell(3, 7);

    /**
     * Next Generation
     *
     * <pre>
     * ........
     * ...***..
     * ...****.
     * ........
     * </pre>
     */
    gameOfLife.nextGeneration();

    int[][] local =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 1, 1, 0, 0},
          {0, 0, 0, 1, 1, 1, 1, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };

    assertEquals(Arrays.deepEquals(gameOfLife.getNextGeneration(), local), true);
  }

  @Test
  public void testVoidGrid() {
    /**
     * Current Generation
     *
     * <pre>
     * ........
     * ........
     * ........
     * ........
     * </pre>
     */

    /**
     * Next Generation
     *
     * <pre>
     * ........
     * ........
     * ........
     * ........
     * </pre>
     */
    gameOfLife.nextGeneration();

    int[][] local =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };

    assertEquals(Arrays.deepEquals(gameOfLife.getNextGeneration(), local), true);
  }

  @Test
  public void testSingleElement() {
    /**
     * Current Generation
     *
     * <pre>
     * ........
     * ........
     * ...*....
     * ........
     * </pre>
     */
    gameOfLife.setLivingCell(2, 3);
    /**
     * Next Generation
     *
     * <pre>
     * ........
     * ........
     * ........
     * ........
     * </pre>
     */
    gameOfLife.nextGeneration();

    int[][] local =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };

    assertEquals(Arrays.deepEquals(gameOfLife.getNextGeneration(), local), true);
  }

  @Test
  public void testFullGrid() {
    /**
     * Current Generation
     *
     * <pre>
     * ********
     * ********
     * ********
     * ********
     * </pre>
     */
    gameOfLife.setLivingCell(0, 0);
    gameOfLife.setLivingCell(0, 1);
    gameOfLife.setLivingCell(0, 2);
    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(0, 6);
    gameOfLife.setLivingCell(0, 7);
    gameOfLife.setLivingCell(1, 0);
    gameOfLife.setLivingCell(1, 1);
    gameOfLife.setLivingCell(1, 2);
    gameOfLife.setLivingCell(1, 3);
    gameOfLife.setLivingCell(1, 4);
    gameOfLife.setLivingCell(1, 5);
    gameOfLife.setLivingCell(1, 6);
    gameOfLife.setLivingCell(1, 7);
    gameOfLife.setLivingCell(2, 0);
    gameOfLife.setLivingCell(2, 1);
    gameOfLife.setLivingCell(2, 2);
    gameOfLife.setLivingCell(2, 3);
    gameOfLife.setLivingCell(2, 4);
    gameOfLife.setLivingCell(2, 5);
    gameOfLife.setLivingCell(2, 6);
    gameOfLife.setLivingCell(2, 7);
    gameOfLife.setLivingCell(3, 0);
    gameOfLife.setLivingCell(3, 1);
    gameOfLife.setLivingCell(3, 2);
    gameOfLife.setLivingCell(3, 3);
    gameOfLife.setLivingCell(3, 4);
    gameOfLife.setLivingCell(3, 5);
    gameOfLife.setLivingCell(3, 6);
    gameOfLife.setLivingCell(3, 7);
    /**
     * Next Generation
     *
     * <pre>
     * ........
     * ........
     * ........
     * ........
     * </pre>
     */
    gameOfLife.nextGeneration();

    int[][] local =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };

    assertEquals(Arrays.deepEquals(gameOfLife.getNextGeneration(), local), true);
  }
}
