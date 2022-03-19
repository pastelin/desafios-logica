package com.linkedlist;

import java.util.Scanner;

public class DeleteDuplicateValue {

    static class SinglyLinkedListNode {
        private int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        private SinglyLinkedListNode head;
        private SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if(this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void SinglyLinkedListPrintHelper(SinglyLinkedListNode node, String sep) {
        while(node != null) {
            System.out.print(node.data);

            node = node.next;

            if(node != null) {
                System.out.print(sep);
            }
        }
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        SinglyLinkedListNode head = llist;

        while(llist.next != null) {
            if(llist.data == llist.next.data) {

                if(llist.next.next != null) {
                    llist.next = llist.next.next;
                } else {
                    llist.next = null;
                    break;
                }
            } else {
                llist = llist.next;
            }
        }

        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el número de pruebas a realizar");
        int t = scanner.nextInt();

        for(int testsItr = 0; testsItr < t; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            System.out.println("Ingrese el número de nodos a ingresar");
            int llistCount = scanner.nextInt();

            for(int i = 0; i < llistCount; i++) {
                System.out.println("Ingrese un valor para el nodo #" +  (i +1));
                int llistItem = scanner.nextInt();

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = removeDuplicates(llist.head);
            SinglyLinkedListPrintHelper(llist1, " ");
        }

        scanner.close();
    }
}
