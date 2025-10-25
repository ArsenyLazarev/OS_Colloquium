package org.example;

import java.util.Scanner;

public class LinkedListReversal {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    private Scanner scanner = new Scanner(System.in);
    private ListNode head;

    public void enterList() {
        System.out.println("Введите числа для создания списка (для завершения введите -1):");

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (true) {
            System.out.print("Введите число (-1 для завершения): ");
            int num = scanner.nextInt();

            if (num == -1) {
                break;
            }

            current.next = new ListNode(num);
            current = current.next;
        }

        head = dummy.next;
        System.out.println("Созданный список: " + listToString(head));
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode reverseIterative() {
        if (head == null) {
            System.out.println("Список пуст");
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    public String listToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverseAndPrint() {
        System.out.println("Исходный список: " + listToString(head));
        reverseIterative();
        System.out.println("Развернутый список: " + listToString(head));
    }
}