package arrays;

public class Girafes {

  public static int solution(int[] arr) {

    int p = arr[0];

    int intCounter = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] - arr[i] != 1) {
        if (arr[i] < p) {
          return 1;
        }
        p = arr[i];
        intCounter++;
      }
    }

    return intCounter;
  }
}
