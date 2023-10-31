package com.shadow.sort.countingsort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 * 计数排序只能用在数据范围不大的场景中，如果数据范围K比要排序的数据n大很多，就不适合用计数排序。
 * 计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数
 *
 * @author austin
 * @since 2023-10-30
 */
public class CountingSort {

    /**
     * 计数排序，假设数组中存储的都是非负整数
     *
     * @param arr 排序的数组
     * @param n   排序数组大小
     */
    public void countingSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        // 查找数组中数据的范围
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[arr[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤
        for (int i = n - 1; i > 0; i--) {
            int index = c[arr[i]] - 1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        // 将结果拷贝给a数组
        System.arraycopy(r, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int length = 500000;
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length / 1000);
        }
        CountingSort sort = new CountingSort();
        sort.countingSort(arr, length);
        System.out.println(Arrays.toString(arr));
    }

}
