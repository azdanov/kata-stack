package org.js.azdanov;

public class Stack {

  private int size = 0;
  private int capacity;

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
  }

  public void pop() {
    size--;
  }

  public class Overflow extends RuntimeException {}
}
