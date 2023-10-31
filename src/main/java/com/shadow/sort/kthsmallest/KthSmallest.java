package com.shadow.sort.kthsmallest;

import java.util.Random;

/**
 * 二叉搜索树第k小节
 *
 * @author austin
 * @since 2023-10-26
 */
public class KthSmallest {

    public int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }
        return arr[partition];
    }

    public int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int length = 100000;
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length * 100);
        }
        KthSmallest kthSmallest = new KthSmallest();
        int i = kthSmallest.kthSmallest(arr, 100);
        System.out.println(i);
    }

}
