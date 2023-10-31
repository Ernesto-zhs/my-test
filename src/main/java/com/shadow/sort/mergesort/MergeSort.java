package com.shadow.sort.mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 *
 * @author austin
 * @since 2023-10-25
 */
public class MergeSort {

    /**
     * 归并排序算法
     *
     * @param arr 数组
     * @param n   数组大小
     */
    public void mergeSort(int[] arr, int n) {
        mergeSortInternally(arr, 0, n - 1);
    }

    /**
     * 递归调用函数
     *
     * @param arr 数组
     * @param p   开始位置
     * @param r   结束位置
     */
    public void mergeSortInternally(int[] arr, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 取p到r之间的中间位置q，防止(p+r)的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);
        // 将A[p..q]和A[q+1..r]合并为A[p..r]
        mergeBySentry(arr, p, q, r);
    }

    public void merge(int[] arr, int p, int q, int r) {
        // 初始化变量i,j,k
        int i = p, j = q + 1, k = 0;
        // 申请一个大小跟A[p..r]一样的临时数组
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        // 将tmp中的数组拷贝回a[p..r]
        for (i = 0; i < r - p; i++) {
            arr[p + i] = tmp[i];
        }
    }

    /**
     * 合并（哨兵）
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        if (q - p + 1 >= 0) System.arraycopy(arr, p, leftArr, 0, q - p + 1);
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0, j = 0, k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(1000000000);
        }
        mergeSort.mergeSort(arr, 10000);
        System.out.println(Arrays.toString(arr));
    }
}
