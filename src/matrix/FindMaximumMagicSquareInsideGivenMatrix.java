package matrix;


/**
 * 
 * @author sergiogp
 *
 */

public class FindMaximumMagicSquareInsideGivenMatrix {
	public static void main(String... strings) {
 
		int[][] arr = new int[][] { { 2, 4 }, { 3, 5 } };
		
		System.out.println("result-" + check2(arr)); 
		System.out.println();
		arr = new int[][] { 
			{ 5, 4, 6}, 
			{ 3, 5, 4}, 
			{ 4, 5, 7} };
		System.out.println("result-" + check2(arr)); 
		System.out.println();
		
		
		 arr = new int[][] { 
			{ 5, 4, 6, 6}, 
			{ 5, 1, 4, 6}, 
			{ 2, 3, 2, 2}, 
			{ 3, 5, 4, 9}}; 
		
		System.out.println("result-" + check2(arr)); 
		System.out.println();
			
		 arr = new int[][] { 
			{ 5, 4, 6, 6}, 
			{ 3, 5, 4, 8}, 
			{ 2, 5, 4, 9}, 
			{ 3, 5, 4, 9}}; 
		
		System.out.println("result-" + check2(arr)); 
		System.out.println();
		
		arr = new int[][] { 
			{ 5, 4, 6, 6}, 
			{ 3, 5, 4, 8}, 
			{ 2, 5, 4, 9}, 
			{ 8, 5, 4, 9}};			
		
		System.out.println("result-" + check2(arr)); 		
		System.out.println();
		arr = new int[][] { 
			{ 5, 4, 6, 6 ,7}, 
			{ 3, 5, 4, 8, 5}, 
			{ 2, 5, 2, 9, 6}, 
			{ 8, 1, 4, 9, 7}, 
			{ 8, 5, 4, 9, 7}};
			
		System.out.println("result-" + check2(arr)); 
			
	}

	public static int check2(int[][] arr) {
		for (int i = arr.length; 1 < i; i--) {
			int result = 0;
			if (0 < (result = check2(arr, i))) {
				return result;
			} 
		}
		return 0;
	}
	
	public static int check2(int[][] arr , int size) {
		
		/**
		 * the +1 is added in order to iterate at least 1 time when size == arr.length
		 */
		for (int i = 0; i < arr.length - size + 1; i++) {
			for (int j = 0; j < arr.length - size + 1; j++) {
				int sum1 = 0;
				int sum2 = 0;
				System.out.printf("i:%d, j:%d\n", i, j);
 
				for (int k = 0; k < size; k++) {
					/* iterate through the rows*/
					int row = i + k;
					/* iterate through the columns, in order to sum the 1st diagonal */
					int column = j + k;
					/* iterate through the columns, in order to sum the 2st diagonal */
					int column1 = j + size - k - 1;
					System.out.printf("\\%d%d(%d) /%d%d(%d) \n", row, column, arr[row][column], row, column1,
							arr[row][column1]);
					/* calculate the sum for every column independently*/
					sum1 += arr[row][column];
					/* calculate the sum for every column independently*/
					sum2 += arr[row][column1];
				}

				if (sum1 == sum2) {
					System.out.printf("sm1:%d sm2:%d\n", sum1, sum2);

					return size;
				}
			}
		}

		return -1;
	}
	
	/**
	 * check if the current matrix is a perfect square
	 * 
	 * 
	 * @param arr
	 */
	public static void check(int[][] arr) {

		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][arr.length - i - 1];
		}
		System.out.printf("sum1:%d, sum2:%d\n", sum1, sum2);
	}
}
