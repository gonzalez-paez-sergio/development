package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GirafesTest {
  private int[][] listCases;
  private int[] listResults;

  @Before
  public void generate() {

    listCases = new int[20][];
    listResults = new int[20];

    listCases[0] = new int[] {5, 4, 3, 2, 1};
    listResults[0] = 1;
    listCases[1] = new int[] {8, 7, 6, 1, 2};
    listResults[1] = 1;
    listCases[2] = new int[] {1, 2, 8, 7, 6};
    listResults[2] = 3;
    listCases[3] = new int[] {4, 3, 2, 6, 1};
    listResults[3] = 1;
    listCases[4] = new int[] {1, 5, 4, 9, 8, 7, 12, 13, 14};
    listResults[4] = 6;
    listCases[5] = new int[] {3, 4, 5};
    listResults[5] = 3;
    listCases[6] = new int[] {3, 4, 5};
    listResults[6] = 3;
    listCases[7] = new int[] {3, 4, 5};
    listResults[7] = 3;
    listCases[8] = new int[] {3, 4, 5};
    listResults[8] = 3;

    int t = 1000;
    listCases[9] = Helper.generateArray("asc", 0, t);
    listResults[9] = t;
    listCases[10] = Helper.generateArray("desc", 0, t);
    listResults[10] = 1;

    // t = 1000;
    listCases[11] = Helper.generateArray("asc", 0, t);
    // listCases[11][100] = 0;
    listResults[11] = t;
    listCases[12] = Helper.generateArray("desc", 0, t);
    listResults[12] = 1;

    listCases[13] = Helper.generateArray("random", 0, t);
    listResults[13] = 1;
  }

  @Test
  public void test0() {
    int[] arr = this.listCases[0];
    assertEquals(listResults[0], Girafes.solution(arr));
  }

  @Test
  public void test1() {
    int[] arr = this.listCases[1];
    assertEquals(listResults[1], Girafes.solution(arr));
  }

  @Test
  public void test2() {
    int[] arr = this.listCases[2];
    assertEquals(listResults[2], Girafes.solution(arr));
  }

  @Test
  public void test3() {
    int[] arr = this.listCases[3];
    assertEquals(listResults[3], Girafes.solution(arr));
  }

  @Test
  public void test4() {
    int[] arr = this.listCases[4];
    assertEquals(listResults[4], Girafes.solution(arr));
  }

  @Test
  public void test5() {
    int[] arr = this.listCases[5];
    assertEquals(listResults[5], Girafes.solution(arr));
  }

  @Test
  public void test6() {
    int[] arr = this.listCases[6];
    assertEquals(listResults[6], Girafes.solution(arr));
  }

  @Test
  public void test7() {
    int[] arr = this.listCases[7];

    System.out.println(arr.length);
    assertEquals(listResults[7], Girafes.solution(arr));
  }

  @Test
  public void test8() {
    int[] arr = this.listCases[8];
    System.out.println(arr.length);
    assertEquals(listResults[8], Girafes.solution(arr));
  }

  @Test
  public void test9() {
    int[] arr = this.listCases[9];
    System.out.println(arr.length);
    assertEquals(listResults[9], Girafes.solution(arr));
  }

  @Test
  public void test9_2() {
    int[] arr = this.listCases[9];
    System.out.println(arr.length);
    assertEquals(listResults[9], Girafes2.solution(arr));
  }

  @Test
  public void test10() {
    int[] arr = this.listCases[10];
    System.out.println(arr.length);
    assertEquals(listResults[10], Girafes.solution(arr));
  }

  @Test
  public void test10_2() {
    int[] arr = this.listCases[10];
    System.out.println(arr.length);
    assertEquals(listResults[10], Girafes2.solution(arr));
  }

  @Test
  public void test11() {
    int[] arr = this.listCases[11];
    System.out.println(arr.length);
    assertEquals(listResults[11], Girafes.solution(arr));
  }

  @Test
  public void test11_2() {
    int[] arr = this.listCases[11];
    System.out.println(arr.length);
    assertEquals(listResults[11], Girafes2.solution(arr));
  }

  @Test
  public void test12() {
    int[] arr = this.listCases[12];
    System.out.println(arr.length);
    assertEquals(listResults[12], Girafes.solution(arr));
  }

  @Test
  public void test12_2() {
    int[] arr = this.listCases[12];
    System.out.println(arr.length);

    assertEquals(listResults[12], Girafes2.solution(arr));
  }

  @Test
  public void test13() {
    int[] arr = this.listCases[13];
    System.out.println(arr.length);
    assertEquals(listResults[13], Girafes.solution(arr));
  }

  @Test
  public void test13_2() {
    int[] arr = this.listCases[13];
    System.out.println(arr.length);

    for (int i = 0; i < 10; i++) {
      System.out.println(arr[i]);
    }

    assertEquals(listResults[13], Girafes2.solution(arr));
  }
}
