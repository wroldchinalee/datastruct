package com.lwq.sort;

import java.util.Arrays;

/**
 * @author: LWQ
 * @create: 2020/10/15
 * @description: SelectSort
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        System.out.println("排序前数组~~");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后数组~~");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 创建两个辅助指针i和j
     * i初始化的时候指向数组起始的位置，j指向i右边的位置
     * 然后从j开始遍历数组，选择最小的值，遍历结束后，与i的位置进行交换
     * 将i的指针+1，重复上述过程，直到i指向了n-1
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (arr[i] > arr[min]) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
