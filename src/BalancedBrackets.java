import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            System.out.println(evaluate(s)?"YES":"NO");
        }
    }
    
    static boolean evaluate (String string){
        Stack stack = new Stack(string.length());
        for (int i = 0; i < string.length(); i++){
            String stringPopItem = null;
            String stringItem = string.substring(i,i+1);
            //System.out.println(stringItem);
            if ("(".equals(stringItem)) 
                stack.push(stringItem);
            else if ("{".equals(stringItem)) 
                stack.push(stringItem);
            else if ("[".equals(stringItem)) 
                stack.push(stringItem);
            else if (")".equals(stringItem)){
                stringPopItem = stack.pop();
                if (!"(".equals(stringPopItem)){
                    return false;
                } 
            } else if ("}".equals(stringItem)) {
                stringPopItem = stack.pop();
                if (!"{".equals(stringPopItem)){
                    return false;
                } 
            } else if ("]".equals(stringItem)) {
                stringPopItem = stack.pop();
                if (!"[".equals(stringPopItem)){
                    return false;
                } 
            }
        }
		//at the end we need to be sure the stack is void
        return stack.isEmpty();
    }
    
    static  class Stack {
        private String[] a; // stack entries
        private int N; // size
        public Stack(int cap){ 
            a = new String[cap]; 
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }
            
        public String pop(){
            // Remove item from top of stack.
            if (this.isEmpty()){
                return null;   
            } 
            String item = a[--N];
            a[N] = null; // Avoid loitering (see text).
            if (N > 0 && N == a.length/4){
				//System.out.printf("resizing from %d to %d",a.length, a.length/2);
				//System.out.println();
                resize(a.length/2);
            }
            return item;
        }
        
        public void push(String item) {
            // Add item to top of stack.
            if (N == a.length) {
                resize(2*a.length);
            }
            a[N++] = item;
        }
        
        private void resize(int max){ // Move stack of size N <= max to a new array of size max.
            String[] temp = new String[max];
            for (int i = 0; i < N; i++)
                temp[i] = a[i];
            a = temp;
        }
    }
}