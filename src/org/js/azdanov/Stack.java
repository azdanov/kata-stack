package org.js.azdanov;

public interface Stack {

  boolean isEmpty();

  int getSize();

  void push(int element);

  int pop();

  int top();

  class Overflow extends RuntimeException {}

  class Underflow extends RuntimeException {}

  class IllegalCapacity extends RuntimeException {}

  class Empty extends RuntimeException {}
}
