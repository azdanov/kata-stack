package org.js.azdanov;

public class Stack {

  private int size = 0;
  private int capacity;
  private int element;

  private Stack(int capacity) {
    this.capacity = capacity;
  }

  public static Stack Make(int capacity) {
    return new Stack(capacity);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public void push(int element) {
    if (size == capacity) {
      throw new Overflow();
    }
    size++;
    this.element = element;
  }

  public int pop() {
    if (size == 0) {
      throw new Underflow();
    }
    size--;
    return element;
  }

  public class Overflow extends RuntimeException {}

  public class Underflow extends RuntimeException {}
}
