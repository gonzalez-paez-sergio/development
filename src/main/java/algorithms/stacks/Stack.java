package algorithms.stacks;

public class Stack<T> {
  private int current;
  private T[] arr;

  public Stack(int size) {
    this.arr = (T[]) new Object[size];
    this.current = 0;
  }

  // insert a new string onto stack
  public void push(T item) {
    if (this.arr.length == this.current) {
      System.out.printf(
          "resize array; this.arr.length:%s, last item:%s, this.current:%s, item to be added:%s\n",
          this.arr.length, this.arr[this.current - 1], this.current, item);
      this.arr = resize();
    }
    this.arr[this.current] = item;
    this.current++;
  }

  private T[] resize() {
    T[] tmp = (T[]) new Object[this.arr.length * 2];
    for (int i = 0; i < this.arr.length; i++) {
      tmp[i] = this.arr[i];
    }
    return tmp;
  }

  // remove and return the string most recently added
  T pop() {
    this.current--;
    T s = this.arr[this.current];
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
