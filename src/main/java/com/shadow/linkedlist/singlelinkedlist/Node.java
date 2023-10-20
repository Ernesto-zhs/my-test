package com.shadow.linkedlist.singlelinkedlist;

public class Node<E> {

    /**
     * 存储本节点数据
     */
    E data;

    /**
     * 存储下一个节点引用
     */
    Node<E> next;

    Node(E element, Node<E> next) {
        this.data = element;
        this.next = next;
    }

}
