package com.shadow.linkedlist.mergetwolists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 合并两个有序链表
 *
 * @author austin
 * @since 2023-10-19
 */
public class Solution {

    /**
     * 粗暴方案：放入一个ArrayList当中排序，然后再转入链表当中
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public ListNode mergeTwoListsForce(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        list.sort(Comparator.comparing(Integer::intValue));
        ListNode listNode = new ListNode(list.get(0));
        ListNode head = new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            head.next = new ListNode(list.get(i));
            listNode.next = head;
        }
        return listNode;
    }

    /**
     * 方案一：递归
     * 如果l1或者l2一开始就是空链表，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断l1和l2哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     * 时间复杂度：O(m + n)，其中n和m分别为两个链表的长度。因为每次调用递归都会去掉l1或者l2的头节点(知道至少有一个链表为空)，
     * 函数mergeTwoList至多只会递归调用每个节点一次，因此，时间复杂度取决于合并后的链表长度，即O(n+m)
     * 空间复杂度：O(n + m)，其中n和m分别为两个链表的长度，递归调用mergeTwoLists函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。
     * 结束递归调用时mergeTwoLists函数最多调用n+m次，因此空间复杂度为O(n+m)
     */
    public ListNode mergeTwoListsOne(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsOne(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsOne(l1, l2.next);
            return l2;
        }
    }

    /**
     * 方法二：迭代
     * 当l1和l2都不是空链表时，判断l1和l2哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
     * 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位
     * 算法：
     * 首先，我们设定一个哨兵节点preHead，这可以在最后让我们比较容易地返回合并后的链表。
     * 我们维护一个prev指针，我们需要做的是调整他的next指针。然后，我们重复以下过程，直到l1或者l2
     * 指向了null：如果l1当前节点的值小于等于l2，我们就把l1当前的节点接在prev节点的后面同时将l1指针往后
     * 移动一位。否则，我们对l2做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把prev向后移动一位。
     * 在循环终止的时候，l1和l2至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含
     * 的所有元素都比前面已经合并链表中的所有元素都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，
     * 并返回合并链表即可
     * 时间复杂度：O(n + m),其中n和m分别为两个链表的长度。因为每次循环迭代中，l1和l2只有一个元素会被放进合并链表
     * 中，因此while循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为O(n+m)
     * 空间复杂度：O(1)。我们只需要常数的空间存放若干变量
     */
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

}
