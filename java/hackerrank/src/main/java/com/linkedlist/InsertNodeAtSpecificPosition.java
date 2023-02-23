package com.linkedlist;

import java.util.Scanner;

public class InsertNodeAtSpecificPosition {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        int counter = 0;
        SinglyLinkedList newLlist = new SinglyLinkedList();

        while (llist != null) {
            if (counter == position) {
                newLlist.insertNode(data);
                newLlist.insertNode(llist.data);
            } else {
                newLlist.insertNode(llist.data);
            }

            counter++;
            llist = llist.next;
        }

        return newLlist.head;
    }

    // Metodo que inserta un noda al final, pero busca el nodo final a insertar cada que se llama al metodo
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode tail = head;

        if(head == null) {
            return node;
        }

        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = node;
        return head;
    }

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        System.out.println("Ingrese número de nodos a agregar");
        int llistCount = entrada.nextInt();
        entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            System.out.println("Valor - Nodo-" + (i + 1));
            int llistItem = entrada.nextInt();
            entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        System.out.println("Ingrese el valor a agregar");
        int data = entrada.nextInt();
        entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Ingrese la posición a agregar el nodo");
        int position = entrada.nextInt();
        entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, "");

        entrada.close();
    }

}
