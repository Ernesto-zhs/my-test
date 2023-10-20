package com.shadow.linkedlist.middlenode;

/**
 * 链表的中间节点
 *
 * @author austin
 * @since 2023-10-20
 */
class Solution {

    /**
     * 方案一：数组
     * 思路和算法
     * 链表的缺点在于不能通过下标访问对应的元素。因此我们可以考虑对链表进行遍历，
     * 同时将遍历到的元素依次放入数组A。如果我们遍历到了N个元素，那么链表以及数组的长度也为N，
     * 对应的中间节点即为A[N/2]
     * 时间复杂度：O(N)，其中N是给定链表中的结点数目
     * 空间复杂度：O(N)，即数组A用去的空间
     */
    public ListNode middleNodeOne(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int t = 0;
        while (head != null) {
            nodes[t++] = head;
            head = head.next;
        }
        return nodes[t / 2];
    }

    /**
     * 方案二：单指针法
     * 对方法一进行空间优化，省去数组A。
     * 对链表进行两次遍历。第一次遍历时，我们统计链表中的元素个数N；第二次遍历时，
     * 我们遍历到第N/2个元素（链表的首节点为第0个元素）时，将该元素返回即可
     * 时间复杂度：O(N)，其中N是给定链表的结点数目
     * 空间复杂度：O(1)，只需要常数空间存放变量与指针
     */
    public ListNode middleNodeTwo(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 方案三：快慢指针法
     * 继续优化方法二，用两个指针slow与fast一起遍历链表。slow一次走一步，
     * fast一次走两步。那么当fast走到链表的末尾时，slow必然位于中间
     * 复杂度分析
     * 时间复杂度：O(N)，其中N是给定链表的节点数目
     * 空间复杂度：O(1)，只需要常数空间存放slow和fast两个指针
     */
    public ListNode middleNodeThree(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}