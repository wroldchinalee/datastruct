package com.lwq.sort;

import java.util.Arrays;

/**
 * @author: LWQ
 * @create: 2020/10/15
 * @description: ShellSort
 **/
public class ShellSort {

    /**
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int t = arr.length / 2;
        while (t > 1) {

        }

    }

    public static void sort(int[] array) {
        //希尔排序的增量
        int d = array.length;
        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
