package com.shadow.queue.circularqueue;

/**
 * 循环队列
 * todo 此循环队列存在问题
 *
 * @author austin-zhs
 * @since 2023-10-23
 */
public class CircularQueue {

    /**
     * 数组 items
     */
    private final String[] items;

    /**
     * 数组大小
     */
    private int n = 0;

    /**
     * head表示队头下标
     */
    private int head = 0;

    /**
     * tail表示队尾下标
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item 元素
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) {
            return;
        }
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(8);
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("2"));
        System.out.println(queue.enqueue("3"));
        System.out.println(queue.enqueue("4"));
        System.out.println(queue.enqueue("5"));
        System.out.println(queue.enqueue("6"));
        System.out.println(queue.enqueue("7"));
        System.out.printf("-----------%s-------------%n", queue.dequeue());
        System.out.printf("-----------%s-------------%n", queue.dequeue());
        System.out.printf("-----------%s-------------%n", queue.dequeue());
        System.out.println(queue.enqueue("8"));
        queue.printAll();
    }
}
