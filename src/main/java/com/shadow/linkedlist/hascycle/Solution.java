package com.shadow.linkedlist.hascycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author austin
 * @since 2023-10-19
 */
public class Solution {

    /**
     * 方案一，使用hash表，每次遍历到一个节点时，判断该节点此前是否被访问过
     * 使用hash表存储所有已经访问过的节点，每次到达一个节点时，如果该节点已经存在于hash表中，则说明该链表是环形链表，否则就将该节点加入hash表中。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean hasCycleOne(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：快慢指针
     * 定义两个指针，一快一慢。满指针每次只移动一步，而快指针每次移动两步。
     * 初始时，满指针在位置head，而快指针在位置head.next。这样依赖，如果在移动过程中，快指针反过来追上慢指针，
     * 就说明该链表为环形链表。否则快指针到达链表尾部，该链表不为环形链表。
     * 时间复杂度O(N)，其中N是链表的节点数
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一，而初始距离为环的长度，因此至多移动N轮
     * 空间复杂度O(1)。我们只用了两个指针的额外空间
     */
    public boolean hasCycleTwo(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}