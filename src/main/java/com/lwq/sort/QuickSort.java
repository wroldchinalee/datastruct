package com.lwq.sort;

import java.util.Arrays;

/**
 * @author: LWQ
 * @create: 2020/10/14
 * @description: QuickSort
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        System.out.println("排序前数组~~");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 7);
        System.out.println("排序后数组~~");
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int start, int end) {
        // 左右已经重合了
        if (start >= end) {
            return;
        }
        // 先开始第一轮排序
        // 选择一个基准元素，我们选择第一个作为基准元素
        int pivot = start;
        // 左右都设置一个指针，来辅助遍历
        int left = start;
        int right = end;
        // 开始遍历元素，遍历结束的条件就是左右指针重合
        while (left != right) {
            // 先从右边开始遍历
            // 循环向左遍历，直到找到比基准元素小的元素
            // 或者left和right重合
            while (arr[right] >= arr[pivot] && right > left) {
                right--;
            }
            // 再从左边开始遍历
            // 循环向右遍历，直到找到比基准元素大的元素
            // 或者left和right重合
            while (arr[left] <= arr[pivot] && left < right) {
                left++;
            }

            // 交换元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 如果left==right，将left与pivot元素交换位置
        if (left == right) {
            int temp = arr[left];
            arr[left] = arr[pivot];
            arr[pivot] = temp;
        }
        // 递归遍历左边部分
        quickSort(arr, start, left);
        // 递归遍历右边部分
        quickSort(arr, left + 1, end);
    }
}
