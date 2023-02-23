package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseLinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int nodeData) {
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

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        List<Integer> dlist = new ArrayList<>();
        SinglyLinkedList llist2 = new SinglyLinkedList();

        while(llist != null) {
            dlist.add(llist.data);
            llist = llist.next;
        }

        for(int i = dlist.size() - 1; i >= 0; i--) {
            llist2.insertNode(dlist.get(i));
        }

        return llist2.head;
    }

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el numero de pruebas a realizar");
        int tests = entrada.nextInt();
        entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            System.out.println("Igrese el numero de nodos a agregar, para la pruebo No." + (testsItr + 1));
            int llistCount = entrada.nextInt();
            entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int i = 0; i < llistCount; i++) {
                System.out.println("Ingrese un valor para el nodo No." + (i + 1));
                int llistItem = entrada.nextInt();
                entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = reverse(llist.head);

            printSinglyLinkedList(llist1, " ");
        }
        entrada.close();
    }


}
