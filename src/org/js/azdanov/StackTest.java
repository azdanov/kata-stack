package org.js.azdanov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    assertThrows(BoundedStack.Underflow.class, () -> stack.pop());
  }

  @Test
  void onValuePushSameValueIsOnTop() {
    stack.push(1);
    assertEquals(1, stack.top());
  }

  @Test
  void onEmptyStackTopThrowsEmpty() {
    assertThrows(BoundedStack.Empty.class, () -> stack.top());
  }

  @Test
  void onZeroCapacityStackTopThrowsEmpty() {
    stack = BoundedStack.Make(0);
    assertThrows(BoundedStack.Empty.class, () -> stack.top());
  }

  @Test
  void onStackWithElementsFindCorrectIndex() {
    stack.push(10);
    stack.push(20);
    assertEquals(Integer.valueOf(1), stack.find(10));
    assertEquals(Integer.valueOf(0), stack.find(20));
  }

  @Test
  void onStackWithoutCorrectElementsFindReturnsNull() {
    stack.push(10);
    stack.push(20);
    assertNull(stack.find(2));
  }

  @Test
  void onZeroCapacityStackFindReturnsNull() {
    stack = BoundedStack.Make(0);
    assertNull(stack.find(2));
  }
}
