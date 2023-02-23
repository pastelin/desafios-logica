package com.linkedlist;

import java.util.Scanner;

public class FindMergePoint {

    static class SinglyLinkedListNode {
        private int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        private SinglyLinkedListNode tail;
        private SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.tail = null;
            this.head = null;
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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while(node != null) {

            System.out.print(node.data);

            node = node.next;

            if(node != null) {
                System.out.print(sep);
            }
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int data = 0;

        INITIAL_WHILE:while(head2 != null) {

            SinglyLinkedListNode head1Temp = head1;

            while(head1Temp != null) {

                if(head1Temp == head2 ) {
                    data = head1Temp.data;
                    break INITIAL_WHILE;
                }

                head1Temp = head1Temp.next;
            }

            head2 = head2.next;
        }

        return data;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese el número de casos a validar");
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {

            System.out.println("Ingrese el indice para realizar la integracion");
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist1 = new SinglyLinkedList();

            System.out.println("Ingrese el numero de nodos que desea");
            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {

                System.out.println("Ingrese un valor para el nodo #" + (i + 1) ) ;
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            System.out.println("Ingrese el numero de nodos que desea");
            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {

                System.out.println("Ingrese un valor para el nodo #" + (i + 1) ) ;
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode ptr1 = llist1.head;
            SinglyLinkedListNode ptr2 = llist2.head;

            for (int i = 0; i < llist1Count; i++) {
                if (i < index) {
                    ptr1 = ptr1.next;
                }
            }

            for (int i = 0; i < llist2Count; i++) {
                if (i != llist2Count-1) {
                    ptr2 = ptr2.next;
                }
            }

            ptr2.next = ptr1;

            int result = findMergeNode(llist1.head, llist2.head);

            System.out.println(result);
        }

        scanner.close();
    }
}
