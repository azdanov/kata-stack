package org.js.azdanov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void newlyCreatedStackIsEmpty() {
    Stack stack = new Stack();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());
  }

  @Test
  void onPushStackSizeIsOne() {
    Stack stack = new Stack();
    stack.push(1);
    assertEquals(1, stack.getSize());
    assertFalse(stack.isEmpty());
  }
}
