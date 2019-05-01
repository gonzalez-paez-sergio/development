package working.with.integer.numbers;

import arrays.Helper;

public class SecondMaximum {

  public static int calculate(int[] arr) {
    Helper.print(arr);
    int max = -1;
    int secondMax = -1;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        secondMax = max;
        max = arr[i];
      }

      if (arr[i] != max && secondMax < arr[i]) {
        secondMax = arr[i];
      }
    }

    // if (secondMax = -1)
    return secondMax;
  }

  public static int calculateIndex(int[] arr) {
    Helper.print(arr);
    int max = -1;
    int maxIndex = -1;
    int secondMax = -1;
    int secondMaxIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        secondMax = max;
        secondMaxIndex = maxIndex;
        max = arr[i];
        maxIndex = i;
      }

      if (arr[i] != max && secondMax < arr[i]) {
        secondMax = arr[i];
        secondMaxIndex = i;
      }
    }
    return secondMaxIndex;
  }
}
