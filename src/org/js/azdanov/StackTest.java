package org.js.azdanov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void newlyCreatedStackIsEmpty() throws Exception {
    Stack stack = new Stack();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());
  }
}
