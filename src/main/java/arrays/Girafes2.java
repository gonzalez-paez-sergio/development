package arrays;

public class Girafes2 {

  public static void main(String[] string) {
    int[] arr = new int[] {5, 4, 3, 2, 1};
    System.out.println(solution(arr));
    arr = new int[] {8, 7, 6, 1, 2};
    System.out.println(solution(arr));
    arr = new int[] {1, 2, 8, 7, 6};
    System.out.println(solution(arr));
    arr = new int[] {4, 3, 2, 6, 1};
    System.out.println(solution(arr));
    arr = new int[] {1, 5, 4, 9, 8, 7, 12, 13, 14};
    System.out.println(solution(arr));
  }

  public static int solution(int[] arr) {
    int[] intComponents = new int[arr.length];

    int intCounter = 0;
    for (int i = 0; i <= arr.length - 1; i++) {
      if (i == arr.length - 1) {
        if (arr[i - 1] - arr[i] != 1) {
          // ok, we are on the same component
          // System.out.printf("different component:%d, %s, %s\n", i, arr[i - 1], arr[i]);
          intComponents[intCounter++] = i;
        }
        break;
      }
      if (arr[i] - arr[i + 1] != 1) {
        // ok, we are on the same component
        // System.out.printf("different component:%d, %s, %s\n", i, arr[i], arr[i + 1]);
        intComponents[intCounter++] = i;
      }
    }

    for (int i = 0; i < intCounter - 1; i++) {
      // System.out.printf("%d, %s, %s\n", i, arr[intComponents[i]],
      // arr[intComponents[i + 1]]);
      if (arr[intComponents[i]] > arr[intComponents[i + 1]]) {
        return 1;
      }
    }
    return Math.max(1, intCounter);
  }
}
