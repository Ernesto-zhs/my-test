package com.shadow.linkedlist.circularlinkedlist;

public class Node<E> {

    private E data;

    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}
