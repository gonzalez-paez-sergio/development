import java.util.Scanner;
import java.util.Iterator;

import search.BinarySearchST;

public class Contacts {
	
	static BinarySearchST st;

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		st = new BinarySearchST<String, String>(t);
        for(int i = 0; i <= t; i++){
            String s = in.nextLine();
			evaluate(s, st);
        }

		System.out.printf(
			"total %d\n" , System.currentTimeMillis() -begin
	    );

    }

	public static void evaluate(String stringLine, BinarySearchST st){
		String[] stringArray = stringLine.split(" ");
		if ("add".equals(stringArray[0])){
			st.put(stringArray[1],stringArray[1]);
		} else if ("find".equals(stringArray[0])){
			find (stringArray[1]);
		}
	}

	public static void find(String string){
		int intRank = st.rank(string);
		int intCounter = 0;			
		int intIterations = 0;			
		if (intRank == 0) { 
			System.out.printf("counter %d, rank==0 %d, iterations %d, first element %s, current element [%s], current length [%d]\n", intCounter, intRank, intIterations, st.getFirst(), string, st.size());
			return;
		} else if (intRank > 0) {
			System.out.printf("counter %d, rank >0 %d, iterations %d, first element %s, current element [%s], current length [%d]\n", intCounter, intRank, intIterations, st.getFirst(), string, st.size());
			return;
		} else if (intRank < 0) {
			System.out.printf("counter %d, rank< 0 %d, iterations %d, first element %s, current element [%s], current length [%d]\n", intCounter, intRank, intIterations, st.getFirst(), string, st.size());
			return;
		}
		
		//System.out.printf("key %s, rank %d, st length %d\n", string, intRank, st.size());
		Iterator iterator = st.keys(string).iterator();
		while (iterator.hasNext()) {
			String stringItem = (String) iterator.next();
			intIterations++;
			System.out.printf("\tstring %s, currentItem %s\n", string, stringItem);
			//System.out.println();
			if (stringItem.startsWith(string)){
				intCounter++;
			} else { //lo he encontrado al menos una vez
				break;
			}
		}

		System.out.printf("%d, rank!=0 %d, iterations %d, first element %s, current element [%s], current length [%d]\n", intCounter, intRank, intIterations, st.getFirst(), string, st.size());
		//System.out.printf("%d\n", intCounter);
		//System.out.println();
	}
}
