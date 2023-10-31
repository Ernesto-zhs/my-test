package com.shadow.sort.bubblesort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author austin
 * @since 2023-10-24
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 数组
     * @param n   数组大小
     */
    public void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // 交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) {
                break; // 没有数据交换，提前退出
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {3, 2, 4, 1, 6, 5};
        bubbleSort.bubbleSort(arr, 6);
        System.out.println(Arrays.toString(arr));
    }

}
