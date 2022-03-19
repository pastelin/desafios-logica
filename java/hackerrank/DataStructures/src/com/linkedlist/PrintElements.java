package com.linkedlist;

import java.util.Scanner;

public class PrintElements {

    static class Node {
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public Node head;
        public Node tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    static void printLinkedList(Node head) {
       Node tail = head;

       while(tail != null) {
           System.out.println(tail.data);
           tail = tail.next;
       }
    }

    static Node insertNodeAtHead(Node llist, int data) {
        Node node = new Node(data);

        if(llist == null) {
            llist = node;
        } else {
            Node nodeTemp = llist;
            llist = node;
            llist.next = nodeTemp;
        }
        return llist;
    }


    public static void main(String[] args) {
	    Scanner entrada = new Scanner(System.in);
        int valorEntrada;
        SinglyLinkedList llist = new SinglyLinkedList();


        for(int i = 0; i < 5; i++) {
            System.out.println("Ingrese un valor");
            valorEntrada = entrada.nextInt();
            //llist.insertNode(valorEntrada);
            llist.head = insertNodeAtHead(llist.head, valorEntrada);
        }

        printLinkedList(llist.head);

    }
}
