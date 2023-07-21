package com.shadow.mediansortedarray;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int v1 = nums1[i];
            int v2 = nums2[i];
            if (v1 < v2) {

            } else {

            }
        }
        return 0;
    }

}