package com.lwq.sort;

import java.util.Arrays;

/**
 * @author: LWQ
 * @create: 2020/10/15
 * @description: InsertSort
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        System.out.println("排序前数组~~");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后数组~~");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组分为两部分，第一部分为已经排好序部分
     * 第二部分为待排序部分
     * 从待排序部分取出第一个元素，与已经排好序部分的元素从右到左进行比较
     * 直到排序的第一个位置或插入到正确位置(待插入元素更大)
     * 一共需要插入n-1轮
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 插入n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 创建一个辅助指针j，指向待插入的元素，
            // 位置是第i个元素的右边第一个元素
            int j = i + 1;
            // 如果待插入的元素比它左边的元素小，并且还没有到最左边（数组0的位置），
            // 那么就交换两个元素的位置，并且将指针跟着移动
            while (arr[j] < arr[j - 1] && j > 0) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
