package ibm;

public class TestingMax {

  public static void main() {}

  int getMax(int[] arr) {
    if (null != arr && arr.length == 0) {
      return -1;
    }

    /// 1 3 5 6 10 7 2 -1
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }

      if (i > 0 && arr[i - 1] > arr[i]) {
        break;
      }
    }
    return max;
  }
}
