package com.lwq.sparsearray;

/**
 * @author: LWQ
 * @create: 2020/10/6
 * @description: SparseArray
 **/
public class SparseArray {

    /**
     * 1.遍历原有数组，计算共有多少个不为0的值
     * 2.再次遍历数组，将不为0的值信息放入到稀疏数组中
     *
     * @param arr
     * @return
     */
    public static int[][] toSparseArray(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }

        int[][] result = new int[count + 1][3];
        result[0][0] = arr.length;
        result[0][1] = arr[0].length;
        result[0][2] = count;

        count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    result[count][0] = i;
                    result[count][1] = j;
                    result[count][2] = arr[i][j];
                    count++;
                }
            }
        }
        return result;
    }

    public static int[][] toOriginArray(int[][] sparseArr) {
        if (sparseArr == null || sparseArr.length == 0) {
            return sparseArr;
        }
        int[][] result = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            result[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return result;
    }

}
