package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintInReverse {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
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

            if(head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String step) {
        while(node != null) {
            System.out.print(node.data);
            node = node.next;

            if(node != null) {
                System.out.print(step);
            }
        }
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        List<Integer> valores = new ArrayList<>();

        while(llist != null) {
            valores.add(llist.data);
            llist = llist.next;
        }

        while(!valores.isEmpty()) {
            System.out.println(valores.remove(valores.size() - 1));
        }
    }

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el numero de casos a validar");
        int tests = entrada.nextInt();
        entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0; i < tests; i++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            System.out.println("Ingrese el numero de elementos para el objeto No." + i+1);
            int llistCount = entrada.nextInt();
            entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for(int j = 0; j < llistCount; j++) {
                System.out.println("Ingrese el valor para la posicion: " + j);
                int llistItem = entrada.nextInt();
                entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            reversePrint(llist.head);
        }

        entrada.close();
    }


}
