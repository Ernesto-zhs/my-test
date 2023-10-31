package com.shadow.sort.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author austin-zhs
 * @since 2023-10-26
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr 数组
     * @param n   数组的大小
     */
    public void quickSort(int[] arr, int n) {
        quickSortInternally(arr, 0, n - 1);
    }

    /**
     * 快速排序递归函数
     *
     * @param arr 数组
     * @param p   起始下标
     * @param r   结束下标
     */
    public void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);
    }

    public int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
//        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int length = 10000;
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length * 100);
        }
        quickSort.quickSort(arr, length);
        System.out.println(Arrays.toString(arr));
    }

}
