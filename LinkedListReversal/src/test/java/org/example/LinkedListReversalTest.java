package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListReversalTest {

    private LinkedListReversal reversal;

    @BeforeEach
    void setUp() {
        reversal = new LinkedListReversal();
    }

    @Test
    void testReverseSingleElementList() {
        LinkedListReversal.ListNode head = new LinkedListReversal.ListNode(1);
        reversal.setHead(head);

        LinkedListReversal.ListNode result = reversal.reverseIterative();

        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    void testReverseTwoElementList() {
        LinkedListReversal.ListNode head = new LinkedListReversal.ListNode(1);
        head.next = new LinkedListReversal.ListNode(2);
        reversal.setHead(head);

        LinkedListReversal.ListNode result = reversal.reverseIterative();

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void testReverseFiveElementList() {
        LinkedListReversal.ListNode head = createListFromArray(new int[]{1, 2, 3, 4, 5});
        reversal.setHead(head);

        LinkedListReversal.ListNode result = reversal.reverseIterative();

        assertNotNull(result);
        int[] expected = {5, 4, 3, 2, 1};
        assertListEquals(expected, result);
    }

    @Test
    void testReverseEmptyList() {
        reversal.setHead(null);

        LinkedListReversal.ListNode result = reversal.reverseIterative();

        assertNull(result);
    }

    @Test
    void testReverseListWithDuplicates() {
        LinkedListReversal.ListNode head = createListFromArray(new int[]{1, 2, 2, 3, 3});
        reversal.setHead(head);

        LinkedListReversal.ListNode result = reversal.reverseIterative();

        assertNotNull(result);
        int[] expected = {3, 3, 2, 2, 1};
        assertListEquals(expected, result);
    }

    @Test
    void testListToStringSingleElement() {
        LinkedListReversal.ListNode head = new LinkedListReversal.ListNode(42);

        String result = reversal.listToString(head);

        assertEquals("[42]", result);
    }

    @Test
    void testListToStringMultipleElements() {
        LinkedListReversal.ListNode head = createListFromArray(new int[]{1, 2, 3, 4, 5});

        String result = reversal.listToString(head);

        assertEquals("[1 -> 2 -> 3 -> 4 -> 5]", result);
    }

    @Test
    void testListToStringEmpty() {
        String result = reversal.listToString(null);

        assertEquals("[]", result);
    }

    private LinkedListReversal.ListNode createListFromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        LinkedListReversal.ListNode dummy = new LinkedListReversal.ListNode(0);
        LinkedListReversal.ListNode current = dummy;

        for (int value : values) {
            current.next = new LinkedListReversal.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private void assertListEquals(int[] expected, LinkedListReversal.ListNode head) {
        LinkedListReversal.ListNode current = head;
        for (int i = 0; i < expected.length; i++) {
            assertNotNull(current, "Список короче ожидаемого на позиции " + i);
            assertEquals(expected[i], current.val, "Несоответствие на позиции " + i);
            current = current.next;
        }
        assertNull(current, "Список длиннее ожидаемого");
    }
}