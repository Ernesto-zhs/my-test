package com.shadow.linkedlist.reversedlinkedlist;



/**
 * 解决方案
 *
 * @author austin
 * @since 2023-10-19
 */
public class Solution {

    /**
     * 方案一
     * 双指针迭代
     *
     * @param head 头部信息
     */
    public ListNode reverseListOne(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 方案二
     * 递归解决方案
     *
     * @param head 头部信息
     */
    public static ListNode reverseListTwo(ListNode head) {

        return null;
    }


}


