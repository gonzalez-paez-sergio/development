package cardinal.health;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/** Created by fabricejeannet on 16/09/2014. */
public class TestGameOfLife {

  @Before
  public void before() {
    gameOfLife = new GameOfLife(4, 8);
  }

  @Test
  public void foundsNoLivingNeighboursInAnEmptyGrid() {

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    // assertEquals(neighboursCount).isEqualTo(0);
    assertEquals(neighboursCount, 0);
  }

  @Test
  public void foundsOneLivingNeighbour() {

    gameOfLife.setLivingCell(0, 3);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 1);
  }

  @Test
  public void foundsTwoLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 2);
  }

  @Test
  public void foundsThreeLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 3);
  }

  @Test
  public void foundsFourLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 4);
  }

  @Test
  public void foundsFiveLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);
    gameOfLife.setLivingCell(2, 5);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 5);
  }

  @Test
  public void foundsSixLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);
    gameOfLife.setLivingCell(2, 5);
    gameOfLife.setLivingCell(2, 4);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 6);
  }

  @Test
  public void foundsSevenLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);
    gameOfLife.setLivingCell(2, 5);
    gameOfLife.setLivingCell(2, 4);
    gameOfLife.setLivingCell(2, 3);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 7);
  }

  @Test
  public void foundsHeightLivingNeighbours() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);
    gameOfLife.setLivingCell(2, 5);
    gameOfLife.setLivingCell(2, 4);
    gameOfLife.setLivingCell(2, 3);
    gameOfLife.setLivingCell(1, 3);

    int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

    assertEquals(neighboursCount, 8);
  }

  @Test
  public void foundsThreeLivingNeighboursForTheTopLeftCornerCell() {

    gameOfLife.setLivingCell(0, 1);
    gameOfLife.setLivingCell(1, 1);
    gameOfLife.setLivingCell(1, 0);

    int neighboursCount = gameOfLife.countlivingNeighbours(0, 0);

    assertEquals(neighboursCount, 3);
  }

  @Test
  public void foundsThreeLivingNeighboursForTheBottomRightCornerCell() {

    gameOfLife.setLivingCell(3, 6);
    gameOfLife.setLivingCell(2, 6);
    gameOfLife.setLivingCell(2, 7);

    int neighboursCount = gameOfLife.countlivingNeighbours(3, 7);

    assertEquals(neighboursCount, 3);
  }

  @Test
  public void aCellWithFewerThanTwoNeighboursDies() {

    gameOfLife.setLivingCell(0, 0);
    gameOfLife.setLivingCell(0, 1);

    gameOfLife.computeNextGeneration();

    assertEquals(gameOfLife.isDead(0, 0), true);
  }

  @Test
  public void aCellWithAtLeastTwoNeighboursLives() {

    gameOfLife.setLivingCell(0, 0);
    gameOfLife.setLivingCell(0, 1);
    gameOfLife.setLivingCell(1, 1);

    gameOfLife.computeNextGeneration();

    assertEquals(gameOfLife.isAlive(0, 0), true);
  }

  @Test
  public void aCellWithMoreThanThreeNeighboursDies() {

    gameOfLife.setLivingCell(1, 4);
    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);
    gameOfLife.setLivingCell(1, 5);

    gameOfLife.computeNextGeneration();

    assertEquals(gameOfLife.isDead(1, 4), true);
  }

  @Test
  public void aDeadCellWithThreeNeighboursGetsAlive() {

    gameOfLife.setLivingCell(0, 3);
    gameOfLife.setLivingCell(0, 4);
    gameOfLife.setLivingCell(0, 5);

    gameOfLife.computeNextGeneration();

    assertEquals(gameOfLife.isAlive(1, 4), true);
  }

  @Test
  public void testAnHandMadeGrid() {

    gameOfLife.setLivingCell(1, 4);
    gameOfLife.setLivingCell(2, 3);
    gameOfLife.setLivingCell(2, 4);

    gameOfLife.computeNextGeneration();

    int[][] expectedGrid =
        new int[][] {
          {
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL,
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL
          },
          {
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL,
                GameOfLife.LIVING_CELL,
            GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL
          },
          {
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL,
                GameOfLife.LIVING_CELL,
            GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL
          },
          {
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL,
            GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL
          }
        };

    assertEquals(Arrays.deepEquals(gameOfLife.grid, expectedGrid), true);
  }

  private GameOfLife gameOfLife;
}
