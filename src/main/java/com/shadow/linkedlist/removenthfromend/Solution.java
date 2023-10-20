package com.shadow.linkedlist.removenthfromend;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表倒数第N个节点
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/">...</a>
 *
 * @author austin
 * @since 2023-10-19
 */
class Solution {

    /**
     * 暴力方案：使用ArrayList容器存储删除，然后再放回到链表当中
     */
    public ListNode removeNthFromEndForce(ListNode head, int n) {
        return null;
    }

    /**
     * 方案一：计算链表的长度
     * 思路与算法，从头节点开始对链表进行一次遍历，得到链表的长度L。
     * 随后我们再从头节点开始对链表进行一次遍历，当遍历到第L - n + 1个节点时，
     * 它就是我们需要删除的节点。
     * 为了方便操作，我们可以从哑节点开始遍历L - n + 1个节点。当遍历到第L - n + 1 个节点时，
     * 他的下一个节点就是我们需要删除的节点，这样我们只需要修改一次指针，就能完成删除操作
     * 复杂度分析
     * 时间复杂度：O(L)，其中L是链表的长度。
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEndOne(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 方法二：栈
     * 在遍历链表的同时将所有节点依次入栈。根据栈[先进后出]的原则，我们弹出栈的第n个节点就是需要删除的节点，
     * 并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。
     * 时间复杂度：O(L)，其中L是链表的长度
     * 空间复杂度：O(L)，其中L是链表的长度。主要为栈的开销。
     */
    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        assert prev != null;
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * 方法三：双指针
     * <p>
     * 我们也可以再不预处理出链表的长度，以及使用常数空间的前提下解决本题
     * 由于我们需要找到倒数第n个节点，因此我们可以使用两个指针first和second同时对链表进行遍历，
     * 并且first比second超前n个节点。当first遍历到链表的末尾时，second就恰好处于倒数第n个节点。
     * </p>
     * <p>
     * 具体的，初始时first和second均指向头节点。我们首先使用first对链表进行遍历，遍历的次数为n。
     * 此时，first和second之间间隔了n-1个节点，即first比second超前了n个节点。
     * </p>
     * <p>
     * 在这之后，我们同时使用first和second对链表进行遍历。当first遍历到链表的末尾（即first为空指针）时，second恰好指向倒数第n个节点。
     * </p>
     * <p>
     * 根据方法一和方法二，如果我们能够得到的时倒数第n个节点的前驱节点而不是倒数第n个节点的话，删除操作会更加方便。因此我们可以考虑
     * 在初始时将second指向哑节点，其余的操作步骤不变。这样一来，当first遍历到链表的末尾时，second的下一个节点就是我们需要删除的节点
     * </p>
     * 时间复杂度：O(L)，其中L是链表的长度
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEndThree(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}