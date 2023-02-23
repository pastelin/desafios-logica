package com.linkedlist;

import java.util.Scanner;

public class DeleteANode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

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

    static class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep) {
            while(node != null) {
                System.out.println(node.data);

                node = node.next;

                System.out.println(sep);
            }
        }
    }

    static class Result {
        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            if(position == 0){
                llist = llist.next;
            } else if(llist != null) {
                SinglyLinkedListNode tail = llist;

                for(int i = 0; i < position - 1; i++) {
                    tail = tail.next;
                }

                tail.next = tail.next.next;
            }
            return llist;
        }
    }

    static class Solution {
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            SinglyLinkedList llist = new SinglyLinkedList();

            System.out.println("Ingrese el numero de nodos a agregar");
            int llistCount = entrada.nextInt();
            entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                System.out.println("Valor - Nodo-" + (i + 1));
                int llistItem = entrada.nextInt();
                entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            System.out.println("Ingrese la posicion a eliminar");
            int position = entrada.nextInt();
            entrada.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

            SinglyLinkedListPrintHelper.printList(llist1, "");

            entrada.close();
        }
    }

}
