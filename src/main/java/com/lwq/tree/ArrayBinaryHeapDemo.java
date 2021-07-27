package com.lwq.tree;

import com.lwq.tree.ArrayBinaryHeap;

/**
 * @author: LWQ
 * @create: 2020/10/20
 * @description: ArrayBinaryHeapDemo
 **/
public class ArrayBinaryHeapDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryHeap arrayBinaryHeap = new ArrayBinaryHeap(arr);
        arrayBinaryHeap.preOrder();
        arrayBinaryHeap.upAdjust();
        System.out.println();
        System.out.println("向上调整之后~~");
        arrayBinaryHeap.preOrder();
        System.out.println();
        System.out.println("构建最大堆~~");
        arrayBinaryHeap.buildHeap();
        arrayBinaryHeap.preOrder();
    }
}
