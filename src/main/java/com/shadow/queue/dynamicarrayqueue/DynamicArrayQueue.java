package com.shadow.queue.dynamicarrayqueue;

/**
 * 动态数组队列
 *
 * @author austin-zhs
 * @since 2023-10-23
 */
public class DynamicArrayQueue {

    /**
     * 定义数组
     */
    private String[] items;

    /**
     * 数组大小
     */
    private int n = 0;

    /**
     * 队头下标
     */
    private int head = 0;

    /**
     * 队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的队列
     *
     * @param capacity 容量大小
     */
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队，将item放入队尾
     */
    public boolean enqueue(String item) {
        // tail == n 表示队列末尾没有空间
        if (tail == n) {
            // tail == n && head == 0，表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = 0; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
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
        String item = items[head];
        head++;
        return item;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue(4);
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("2"));
        System.out.println(queue.enqueue("3"));
        queue.printAll();
    }
}
