package chapter1;

import java.sql.SQLOutput;

class LinkedListBase {
    //链表基础操作
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Method to insert a new node
    public static LinkedListBase insert(LinkedListBase list, int data) {
        Node new_node = new Node(data);
        //new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        return list;
    }

    //Method to print the LinkedListBase
    public static void printList(LinkedListBase list) {
        Node currNode = list.head;

        System.out.print("LinkedListBase: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    //Method to delete a node in the LinkedListBase by key
    public static LinkedListBase deleteByKey(LinkedListBase list, int key) {
        Node currNode = list.head;
        Node prev = null;

        //key在表头
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }

        //key不在表头
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        //key不存在
        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedListBase list = new LinkedListBase();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printList(list);

        deleteByKey(list, 1);
        printList(list);
        deleteByKey(list, 4);
        printList(list);
        deleteByKey(list, 8);
        printList(list);
        deleteByKey(list, 10);
        printList(list);
    }
}
