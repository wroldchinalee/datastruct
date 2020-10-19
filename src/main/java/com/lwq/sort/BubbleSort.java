package com.lwq.sort;

import java.util.Arrays;

/**
 * @author: LWQ
 * @create: 2020/10/15
 * @description: BubbleSort
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        System.out.println("排序前数组~~");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后数组~~");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 每一轮将最大的元素放在最后的位置
     * 元素的移动通过相邻之间比较
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        // 进行n-1轮
        for (int i = 0; i < arr.length - 1; i++) {
            // 依次比较元素，把最大的元素放到最后
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
