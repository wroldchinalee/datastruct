package com.lwq.sparsearray;

/**
 * @author: LWQ
 * @create: 2020/10/6
 * @description: SparseArrayDemo
 **/
public class SparseArrayDemo {

    public static void main(String[] args) {
        int[][] arr = new int[6][7];
        arr[0][3] = 22;
        arr[0][6] = 15;
        arr[1][1] = 11;
        arr[1][5] = 17;
        arr[2][3] = -6;
        arr[3][5] = 39;
        arr[4][0] = 91;
        arr[5][2] = 28;
        printArray(arr);
        System.out.println("转化后的稀疏数组为：");
        int[][] sparseArr = SparseArray.toSparseArray(arr);
        printArray(sparseArr);
        System.out.println("还原后的原始数组为：");
        int[][] originArr = SparseArray.toOriginArray(sparseArr);
        printArray(originArr);


    }

    public static void printArray(int[][] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("array is null or empty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}
