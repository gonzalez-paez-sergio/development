package algorithms.stacks;

public class StackOfStrings {
  private int current;
  private String[] arr;

  public StackOfStrings(int size) {
    this.arr = new String[size];
    this.current = 0;
  }
  // insert a new string onto stack
  void push(String item) {
    if (this.arr.length == this.current) {
      System.out.printf(
          "resize array; this.arr.length:%s, last item:%s, this.current:%s, item to be added:%s\n",
          this.arr.length, this.arr[this.current - 1], this.current, item);
      this.arr = resize();
    }
    this.arr[this.current] = item;
    this.current++;
  }

  private String[] resize() {
    String[] tmp = new String[this.arr.length * 2];
    for (int i = 0; i < this.arr.length; i++) {
      tmp[i] = this.arr[i];
    }
    return tmp;
  }

  // remove and return the string most recently added
  String pop() {
    this.current--;
    String s = this.arr[this.current];
    this.arr[this.current] = null;
    return s;
  }

  // is the stack empty?
  boolean isEmpty() {
    return this.current <= 0;
  }

  // number of strings on the stack
  int size() {
    return this.current;
  }
}
