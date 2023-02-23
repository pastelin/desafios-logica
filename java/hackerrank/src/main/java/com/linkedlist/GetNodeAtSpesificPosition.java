package com.linkedlist;

import java.util.Scanner;

public class GetNodeAtSpesificPosition {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
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

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode llistTemp = llist;

        int contador = -1;

        while(llistTemp != null) {
            contador++;
            llistTemp = llistTemp.next;
        }

        for(int i = contador; i >= 0; i--) {
            if(i == positionFromTail) {
                break;
            }
            llist = llist.next;
        }

        return llist.data;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el numero de casos a validar");
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            System.out.println("Ingrese el numero de nodos para el caso #" + (testsItr + 1));
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int i = 0; i < llistCount; i++) {
                System.out.println("Ingrese el valor para el nodo #" + (i + 1));
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            System.out.println("Eliga la posicion a buscar");
            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = getNode(llist.head, position);
            System.out.println("result = " + result);
        }

        scanner.close();
    }
}
