package arrays;

// you can also use imports, for example:
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * @author sergiogp
 * 
 * 
 * 
 *         <pre>
 * 
 * 
 * 
 * Training center
Check out Codility training tasks
Candidate Report:
Anonymous
Test Name:
SUMMARY
Test Score
33 out of 100 points
33
%
Tasks in Test
Time Spent
Task Score
MissingInteger
Submitted in: Java
19 min
33%
TASKS DETAILS
EASY
1. MissingInteger
Find the smallest positive integer that does not occur in a given sequence.
Task Score
33%
Correctness
20%
Performance
50%
Task description
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
Solution
Programming language used
Java
Total time used
19 minutes
Effective time used
19 minutes
Notes
not defined yet
Task timeline

  
  
  
  
  
04:25:16
04:06:27
Code: 04:25:16 UTC, java, final, score:  33
show code in pop-up
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
// you can also use imports, for example:
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] arr) {
        // write your code in Java SE 8
        Arrays.sort(arr);
    //    System.out.println(Arrays.toString(arr));
        int p = arr[0];
        if (p > 1){
            return p-1;
        }
        for (int i = 1; i < arr.length;i++){
                if (arr[i] < 0){
                    if (i== arr.length -1) {
                        return 1;
                    }
                    continue;
                    
                }
                
               // System.out.println(arr[i]-arr[i-1]);
                if (arr[i]-arr[i-1] > 1){//that is

                    
                
                    return arr[i-1] + 1;
                }
        }
        
        return arr[arr.length-1] + 1;
        
    }
}
Analysis summary
The following issues have been detected: wrong answers.

For example, for the input [-1] the solution returned a wrong answer (got 0 expected 1).

Analysis
collapse allExample tests
▶ example1 
first example test ✔OK
1. 0.004 s OK
▶ example2 
second example test ✔OK
1. 0.004 s OK
▶ example3 
third example test ✔OK
1. 0.008 s OK
collapse allCorrectness tests
▶ extreme_single 
a single element ✘WRONG ANSWER 
got 0 expected 1
1. 0.004 s OK
2. 0.008 s OK
3. 0.004 s OK
4. 0.004 s WRONG ANSWER,  got 0 expected 1
▶ simple 
simple test ✘WRONG ANSWER 
got 89 expected 1
1. 0.004 s OK
2. 0.004 s OK
3. 0.004 s WRONG ANSWER,  got 89 expected 1
▶ extreme_min_max_value 
minimal and maximal values ✘WRONG ANSWER 
got -999999 expected 1
1. 0.008 s WRONG ANSWER,  got -999999 expected 1
2. 0.004 s WRONG ANSWER,  got -999999 expected 6
▶ positive_only 
shuffled sequence of 0...100 and then 102...200 ✘WRONG ANSWER 
got 99 expected 1
1. 0.008 s OK
2. 0.008 s WRONG ANSWER,  got 99 expected 1
▶ negative_only 
shuffled sequence -100 ... -1 ✔OK
1. 0.008 s OK
collapse allPerformance tests
▶ medium 
chaotic sequences length=10005 (with minus) ✘WRONG ANSWER 
got -53 expected 5
1. 0.028 s OK
2. 0.028 s OK
3. 0.036 s WRONG ANSWER,  got -53 expected 5
▶ large_1 
chaotic + sequence 1, 2, ..., 40000 (without minus) ✔OK
1. 0.252 s OK
▶ large_2 
shuffled sequence 1, 2, ..., 100000 (without minus) ✔OK
1. 0.288 s OK
2. 0.288 s OK
▶ large_3 
chaotic + many -1, 1, 2, 3 (with minus) ✘WRONG ANSWER 
got 0 expected 10000
1. 0.184 s WRONG ANSWER,  got 0 expected 10000
 * 
 * 
 * 
 *         </pre>
 * 
 * 
 * 
 *
 */
class Solution {

	public static void main(String[] string) {
		int[] arr = new int[] { 1 };
		System.out.println(solution(arr));
		arr = new int[] { 2 };
		System.out.println(solution(arr));
		arr = new int[] { -3, -1 };
		System.out.println(solution(arr));
		arr = new int[] { 0, 7, 8, 9, 5, 4 };
		System.out.println(solution(arr));
		arr = new int[] { 9494, 4848, 2992, 3, 4, 5, 7, 3 };
		System.out.println(solution(arr));
		arr = new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
		System.out.println(solution(arr));
		arr = new int[] { 0, 1 };
		System.out.println(solution(arr));
		arr = new int[] { 4, 5, 6, 2 };
		System.out.println(solution(arr));

	}

	public static int solution(int[] arr) {

		// System.out.println(Arrays.toString(arr));
		if (arr.length == 1) {
			if (arr[0] > 1 || arr[0] < 0) {
				return 1;
			}
			return arr[0] + 1;
		}
		// write your code in Java SE 8
		Arrays.sort(arr);
		if (arr[0] > 1 || arr[arr.length - 1] <= 0) {
			return 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < 0) {
				if (i == arr.length - 1) {
					return 1;
				}
				continue;
			}
			if (arr[i] - arr[i - 1] > 1) {// that is
				return arr[i - 1] + 1;
			}
		}

		return arr[arr.length - 1] + 1;

	}
}