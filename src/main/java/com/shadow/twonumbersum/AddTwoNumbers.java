package com.shadow.twonumbersum;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和
 *
 * @author austin
 * @since 2023-07-24
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        boolean nextAdd = false;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int v = v1 + v2 + (nextAdd ? 1 : 0);
            list.add(v >= 10 ? v % 10 : v);
            nextAdd = v >= 10;
        }
        if (nextAdd) {
            list.add(1);
        }
        ListNode listNode = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            listNode = new ListNode(list.get(i), listNode);
        }
        return listNode;
    }

}

