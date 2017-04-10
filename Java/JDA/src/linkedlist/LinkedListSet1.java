package linkedlist;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class LinkedListSet1 {

    Node head;  // head of list

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        } // Constructor
    }

    public void PrintNodeList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    public static void main(String[] args) {
        LinkedListSet1 listSet1 = new LinkedListSet1();
        listSet1.head = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);

        listSet1.head.next = one;
        one.next = two;

        listSet1.PrintNodeList();
        //System.out.println(" " + PrintNodeList);
    }
}
