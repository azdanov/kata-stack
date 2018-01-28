package org.js.azdanov;

public class Stack {

  private int size = 0;
  private int capacity;
  private int elements[];

  private Stack(int capacity) {
    this.capacity = capacity;
    elements = new int[capacity];
  }

  public static Stack Make(int capacity) {
    if (capacity < 0) {
      throw new IllegalCapacity();
    }
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
    this.elements[size++] = element;
  }

  public int pop() {
    if (size == 0) {
      throw new Underflow();
    }
    return elements[--size];
  }

  public static class IllegalCapacity extends RuntimeException {}

  public class Overflow extends RuntimeException {}

  public class Underflow extends RuntimeException {}
}
