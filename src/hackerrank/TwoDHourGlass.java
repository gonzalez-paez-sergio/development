package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
*
* <pre>
Context
Given a 2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g

There are hourglasses in , and an hourglass sum is the sum of an hourglass' values.

Task
Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Input Format

There are lines of input, where each line contains space-separated integers describing 2D Array ; every value in will be in the inclusive range of to .

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output

19

Explanation

contains the following hourglasses:

1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0

The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4
*
** </pre>
*/
public class TwoDHourGlass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
	
		int[][] sums = calculate(arr);
		int intMax = Integer.MIN_VALUE;
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < sums.length; j++) {
				//System.out.printf("i=%d,j=%d,sum=%d\n",i,j,sums[i][j]);
				if (intMax < sums[i][j]) {
					intMax = sums[i][j];
				}
			}
		}

		System.out.println(intMax);
	}

	public static int[][] calculate (int[][] arr){
		int [][] sums = new int[arr.length-2][arr.length-2];
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < sums.length; j++) {
				//print(arr,i,j);
				sums[i][j] = calculate(arr,i,j);
			}
		}

		return sums;
	}

	public static int calculate (int[][] arr, int i, int j) {
		int sum = 0;
		sum = (arr[i][j] + arr[i][j+1] + arr[i][j+2]);
		sum += arr[i+1][j+1];
		sum += (arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
		return sum;
	}

	static void print(int[][] arr,int i,int j){
		System.out.printf("%d %d %d\n",arr[i][j] , arr[i][j+1] , arr[i][j+2]);
		System.out.printf("..%d..\n",arr[i+1][j+1]);
		System.out.printf("%d %d %d\n",arr[i+2][j] , arr[i+2][j+1] , arr[i+2][j+2]);
	}
}