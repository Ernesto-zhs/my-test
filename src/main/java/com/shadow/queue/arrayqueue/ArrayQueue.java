package com.shadow.queue.arrayqueue;

/**
 * 数组队列
 *
 * @author austin
 * @since 2023-10-23
 */
public class ArrayQueue {

    /**
     * 数组：items
     */
    private final String[] items;

    /**
     * 数组大小：n
     */
    private final int n;

    /**
     * head表示队列头下标
     */
    private int head;

    /**
     * tail表示队尾下标
     */
    private int tail;

    /**
     * 申请一个大小未为capacity的数组
     *
     * @param capacity 容量大小
     */
    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     *
     * @param item 元素
     * @return 是否成功
     */
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列末尾没有空间了
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
            return false;
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
        return items[head++];
    }

}
