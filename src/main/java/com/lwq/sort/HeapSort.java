package com.lwq.sort;

import com.lwq.tree.ArrayBinaryHeap;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: LWQ
 * @create: 2020/10/20
 * @description: HeapSort
 **/
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 4, 3, 2, 1};
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        heapSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
//System.out.println("排序后=" + Arrays.toString(arr));
    }

    /**
     * 1.构建一个最大堆，然后将堆顶元素与最后一个元素交换，那么最大的元素就放在数组的最后了
     * 2.重新将数组调整为最大堆，循环将堆顶元素与倒数第i个位置交换，完成排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        ArrayBinaryHeap arrayBinaryHeap = new ArrayBinaryHeap(arr);
        arrayBinaryHeap.buildHeap();
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            arrayBinaryHeap.downAdjust(0, i);
        }
    }
}
