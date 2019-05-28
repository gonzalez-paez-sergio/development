package algorithms.stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackTestClient {
  public static void main(String[] args) {
    Stack<String> stack = new Stack(4);
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop());
      else stack.push(s);
    }
  }

  public static void main2(String[] args) {
    StackOfStrings stack = new StackOfStrings(4);
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop());
      else stack.push(s);
    }
  }

  public static void main1(String[] args) {
    StackOfStringsLinkedList stack = new StackOfStringsLinkedList();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop());
      else stack.push(s);
    }
  }
}
