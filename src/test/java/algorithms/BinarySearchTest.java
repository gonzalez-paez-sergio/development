package algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void test() {
    int[] whitelist = In.readInts("src/main/resources//algorithms/tinyW.txt");
    Arrays.sort(whitelist);
    BinarySearch binarySearch = new BinarySearch();
    int[] keys = new int[] {10, 3030, 29};
    for (int i = 0; i < keys.length; i++) {
      int key = keys[i];
      int result = binarySearch.rank(key, whitelist);
      if (result < 0) {
        StdOut.println("key " + key + " not found:" + result);
      } else {
        StdOut.println("key " + key + " found:" + result);
      }
    }
  }
}
