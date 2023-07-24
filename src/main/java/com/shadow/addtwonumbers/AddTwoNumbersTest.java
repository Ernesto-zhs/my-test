package com.shadow.addtwonumbers;

public class AddTwoNumbersTest {

    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = null;
        for (int i = arr1.length - 1; i >= 0; i--) {
            l1 = new ListNode(arr1[i], l1);
        }
        ListNode l2 = null;
        for (int i = arr2.length - 1; i >= 0; i--) {
            l2 = new ListNode(arr2[i], l2);
        }
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
    }
}
