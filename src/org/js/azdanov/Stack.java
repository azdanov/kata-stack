package org.js.azdanov;

public class Stack {

  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public void push(int element) {
    size++;
  }
}
