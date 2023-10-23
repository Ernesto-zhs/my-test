package com.shadow.stack.arraystack;

/**
 * 数组栈
 * 先进后出,只允许在一端插入和删除数据
 *
 * @author austin
 * @since 2023-10-20
 */
public class ArrayStack {

    private final String[] items; // 数组

    private int count; // 栈中元素个数

    private final int n; // 栈的大小

    /**
     * 初始化数组，申请一个大小为n的数组空间
     *
     * @param n 初始化栈的容量
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈操作
     */
    public boolean push(String item) {
        // 数组空间不够了，直接返回false，入栈失败
        if (count == n) {

            return false;
        }
        // 将item放到下标为count的位置，并且count加1
        items[count++] = item;
        return true;
    }

    /**
     * 出栈操作
     */
    public String pop() {
        // 栈为空，则直接返回null
        if (count == 0) {
            return null;
        }
        // 返回下标为count-1的数组元素，并且栈元素个数减1
        return items[--count];
    }

}
