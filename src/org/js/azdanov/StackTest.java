package org.js.azdanov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  private Stack stack;

  @BeforeEach
  public void setUp() {
    stack = BoundedStack.Make(2);
  }

  @Test
  void newlyCreatedStackIsEmpty() {
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());
  }

  @Test
  void onPushStackSizeIsOne() {
    stack.push(1);
    assertEquals(1, stack.getSize());
    assertFalse(stack.isEmpty());
  }

  @Test
  void onPushPopStackSizeIsZero() {
    stack.push(1);
    stack.pop();
    assertEquals(0, stack.getSize());
    assertTrue(stack.isEmpty());
  }

  @Test
  void onPushStackOverflows() {
    assertThrows(
        BoundedStack.Overflow.class,
        () -> {
          stack.push(1);
          stack.push(2);
          stack.push(3);
        });
  }

  @Test
  void onPopStackUnderflows() {
    assertThrows(BoundedStack.Underflow.class, () -> stack.pop());
  }

  @Test
  void onPushAndPopSameValueIsReceived() {
    stack.push(1);
    assertEquals(1, stack.pop());
  }

  @Test
  void onMultiplePushAndPopCorrectValuesAreReceived() {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
  }

  @Test
  void onNegativeSizeStackCreationThrowIllegalCapacity() {
    assertThrows(BoundedStack.IllegalCapacity.class, () -> BoundedStack.Make(-1));
  }

  @Test
  void onPushZeroCapacityStackOverflows() {
    stack = BoundedStack.Make(0);
    assertThrows(BoundedStack.Overflow.class, () -> stack.push(1));
  }

  @Test
  void onPopZeroCapacityStackUnderflows() {
    stack = BoundedStack.Make(0);
    assertThrows(BoundedStack.Overflow.class, () -> stack.pop());
  }
}
