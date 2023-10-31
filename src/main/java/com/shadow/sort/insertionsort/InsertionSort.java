package com.shadow.sort.insertionsort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author austin-zhs
 * @since 2023-10-24
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param arr 数组
     * @param n   数组大小
     */
    public void insertionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] arr = {3, 2, 4, 1, 6, 5};
        sort.insertionSort(arr, 6);
        System.out.println(Arrays.toString(arr));
    }

}
