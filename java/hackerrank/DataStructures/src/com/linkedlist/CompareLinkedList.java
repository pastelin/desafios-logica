package com.linkedlist;

import java.util.Scanner;

public class CompareLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public  SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {

        while(node != null) {
            System.out.print(node.data);

            node = node.next;

            if(node != null) {
                System.out.print(sep);
            }
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        boolean isEsquals = true;

        while(head1 != null || head2 != null) {

            if(head1.data != head2.data) {
                isEsquals = false;
                break;
            }

            head1 = head1.next;
            head2 = head2.next;

            if( (head1 == null && head2 != null) || (head1 != null && head2 == null)  ) {
                isEsquals = false;
                break;
            }
        }

        return isEsquals;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el numero de pruebas que quiere realizar");
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int testsItr = 0; testsItr < tests; testsItr++) {

            SinglyLinkedList llist1 = new SinglyLinkedList();

            System.out.println("Ingrese el número de nodos a ingresar");
            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int i = 0; i < llist1Count; i++) {

                System.out.println("Ingres el valor para la prueba #" + (testsItr + 1) + " en el nodo #" + (i + 1));
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            System.out.println("Ingrese el número de nodos a ingresar");
            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int i = 0; i < llist2Count; i++) {

                System.out.println("Ingres el valor para la prueba #" + (testsItr + 1) + " en el nodo #" + (i + 1));
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            boolean result = compareLists(llist1.head, llist2.head);
            System.out.println( result ? 1 : 0 );
        }
        scanner.close();
    }

}
