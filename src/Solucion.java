import java.util.Scanner;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Iterator;

public class Solucion { 

	
	static TreeSet treeSet = new TreeSet();

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		long begin = System.currentTimeMillis();
	    for(int i = 0; i <= t; i++){
            String s = in.nextLine();
			evaluate(s);
        }

		System.out.printf(
			"total %d\n" , System.currentTimeMillis() -begin
	    );
    }

	public static void evaluate(String stringLine){
		String[] stringArray = stringLine.split(" ");
		if ("add".equals(stringArray[0])){
			treeSet.add(stringArray[1]);
		} else if ("find".equals(stringArray[0])){
			System.out.println(
				find2 (stringArray[1])
			);
		}
	}

	public static int find(String string){
		String stringFloor = (String) treeSet.floor(string);
		if (null == stringFloor){
			return 0;
		} 

		int intCounter = 0;
		SortedSet treeSet1 = treeSet.tailSet(stringFloor);
		Iterator iterator = treeSet1.iterator();
		while (iterator.hasNext()) {
			String stringItem = (String)iterator.next();
			if (stringItem.startsWith(string)){
				intCounter++;
			}
		}

		return intCounter;
	}
	
	public static int find1(String string){
		int intCounter = 0;
		Iterator iterator = treeSet.descendingIterator();
		while (iterator.hasNext()) {
			String stringItem = (String)iterator.next();
			if (stringItem.startsWith(string)){
				intCounter++;
			}
		}
		return intCounter;
	}

	public static int find2(String string){
		int intCounter = 0;
		boolean boleanFound=false;
		Iterator iterator = treeSet.descendingIterator();
		while (iterator.hasNext()) {
			String stringItem = (String)iterator.next();
			if (stringItem.startsWith(string)){
				intCounter++;
				boleanFound=true;
			} else if (boleanFound)	{
				break;
			}
		}
		return intCounter;
	}

	public static int find3(String string){
		String stringFloor = (String) treeSet.floor(string);
		if (null == stringFloor){
			return 0;
		} 
		
		int intCounter = 0;
		boolean boleanFound=false;
		Iterator iterator = treeSet.descendingIterator();
		while (iterator.hasNext()) {
			String stringItem = (String)iterator.next();
			if (stringItem.startsWith(string)){
				intCounter++;
				boleanFound=true;
			} else if (boleanFound)	{
				break;
			}
		}
		return intCounter;
	}

	public static int find4(String string){
		String stringFloor = (String) treeSet.floor(string);
		if (null == stringFloor){
			return 0;
		} 
		
		int intCounter = 0;
		boolean boleanFound=false;
		Iterator iterator = treeSet.descendingIterator();
		while (iterator.hasNext()) {
			String stringItem = (String)iterator.next();
			if (stringItem.startsWith(string)){
				intCounter++;
				boleanFound=true;
			} else if (boleanFound)	{
				break;
			}
		}
		return intCounter;
	}
}