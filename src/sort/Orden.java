package sort;

/**

	Dado un arreglo A=[9,4,7,2,1,6,...] este arreglo define un orden, asi qe dado cualquier otro arreglo este ultimo se debe ordenar de acuerdo al orden definido en A
*/

public class Orden {

	public static void main(String[] string){
		int[] A={9,4,7,2,1,5,6,3};
		int[] B={1,2,3,4,5,9,7};
		print(B);
		System.out.println();
		insertionSort(A,B);
		print(B);
	}

	public static void selectionSort(int[] A, int[] B){
		for(int i = 0; i<B.length; i++){
			for(int j = i; j<B.length; j++){
				if(indexOf(A,B[j]) < indexOf(A,B[i])){
					exch(B,i,j);
				}		
			}
		}
	}

	public static void insertionSort(int[] A, int[] B){
		for(int i = 1; i<B.length; i++){
			for(int j = i; j > 0 && indexOf(A,B[j]) < indexOf(A,B[j-1]); j--){
				exch(B,j,j-1	);
			}
		}
	}

	public static int indexOf(int[] A, int intValue){
		for(int i = 0; i < A.length; i++){
			if (A[i] == intValue){
				return i;
			}
		}
		return -1;
	}

	public static void exch(int[] B,int i, int j){
		int tmp = B[i]; B[i] = B[j]; B[j] = tmp;
	}

	public static void print(int[] B){
		for (int i = 0; i<B.length; i++){
			System.out.printf("B[%d]=%d\n",i,B[i]);
		}
	}
}
