package com.shadow.queue.linkedlistqueue;

/**
 * 定义一个链表
 *
 * @author austin
 * @since 2023-10-23
 */
public class ListNode {

    /**
     * 值
     */
    String data;

    /**
     * 节点
     */
    ListNode next;

    public ListNode(String data) {
        this.data = data;
    }

    public ListNode(String data, ListNode next) {
        this.data = data;
        this.next = next;
    }


}
