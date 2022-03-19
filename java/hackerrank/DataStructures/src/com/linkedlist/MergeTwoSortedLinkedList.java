package com.linkedlist;

import java.util.Scanner;

public class MergeTwoSortedLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            head = null;
            tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if(this.head == null) {
                this.head = node;
            }
            else {
                this.tail.next = node;
            }
            this.tail = node;
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

        public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            SinglyLinkedListNode head = head1;
            SinglyLinkedListNode mergeHead = head1;
            int contador = 1;

            while(mergeHead.next != null) {
                mergeHead = mergeHead.next;
            }

            mergeHead.next = head2;

            while(contador != 0) {
                contador = 0;
                head1 = head;

                while(head1.next != null) {
                     int data1 = head1.data;
                     int data2 = head1.next.data;

                     if(data2 < data1) {
                         head1.data = data2;
                         head1.next.data = data1;
                         contador++;
                     }
                     head1 = head1.next;
                 }
            }
            return head;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el numero de pruebas");
            int tests = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int testsItr = 0; testsItr < tests; testsItr++) {
                SinglyLinkedList llist1 = new SinglyLinkedList();

                System.out.println("Ingrese el numero de nodos a utilizar");
                int llist1Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for(int i = 0; i < llist1Count; i++) {
                    System.out.println("Ingrese el valor para el nodo #" + (i + 1));
                    int llist1Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist1.insertNode(llist1Item);
                }

                SinglyLinkedList llist2 = new SinglyLinkedList();

                System.out.println("Ingrese el numero de nodos a utilizar");
                int llist2Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for(int i = 0; i < llist2Count; i++) {
                    System.out.println("Ingrese el valor para el nodo #" + (i + 1));
                    int llist2Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist2.insertNode(llist2Item);
                }



                SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
                printSinglyLinkedList(llist3, " ");

            }
            scanner.close();

        }
    }


}
