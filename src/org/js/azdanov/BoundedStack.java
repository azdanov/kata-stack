package org.js.azdanov;

public class BoundedStack implements Stack {

  private int size = 0;
  private int capacity;
  private int elements[];

  private BoundedStack(int capacity) {
    this.capacity = capacity;
    elements = new int[capacity];
  }

  public static Stack Make(int capacity) {
    if (capacity < 0) {
      throw new IllegalCapacity();
    }
    if (capacity == 0) {
      return new ZeroCapacityStack();
    }
    return new BoundedStack(capacity);
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public static class Overflow extends RuntimeException {}

  public static class Underflow extends RuntimeException {}

  private static class ZeroCapacityStack implements Stack {

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public int getSize() {
      return 0;
    }

    @Override
    public void push(int element) {
      throw new Overflow();
    }

    @Override
    public int pop() {
      throw new Underflow();
    }
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void push(int element) {
    if (size == capacity) {
      throw new Overflow();
    }
    this.elements[size++] = element;
  }

  @Override
  public int pop() {
    if (size == 0) {
      throw new Underflow();
    }
    return elements[--size];
  }
}
