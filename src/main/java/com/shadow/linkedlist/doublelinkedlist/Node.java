package com.shadow.linkedlist.doublelinkedlist;

public class Node<E> {

    private Node<E> prev;

    private E data;

    private Node<E> next;

    public Node(Node<E> prev, E data, Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

}
