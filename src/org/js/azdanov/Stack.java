package org.js.azdanov;

public interface Stack {

  boolean isEmpty();

  int getSize();

  void push(int element);

  int pop();

  public static class IllegalCapacity extends RuntimeException {}
}
