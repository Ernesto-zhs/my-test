package com.shadow.queue.linkedlistqueue;

/**
 * 链表队列
 *
 * @author austin
 * @since 2023-10-23
 */
public class LinkedListQueue {

    private ListNode head;

    private ListNode tail;

    /**
     * 进队
     *
     * @param value 节点数据
     */
    public void enqueue(String value) {
        if (tail == null) {
            ListNode newNode = new ListNode(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new ListNode(value, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public void printAll() {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.printAll();
        System.out.printf("------%s----%n",queue.dequeue());
        queue.printAll();
    }

}
