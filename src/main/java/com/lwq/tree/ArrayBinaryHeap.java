package com.lwq.tree;

/**
 * @author: LWQ
 * @create: 2020/10/20
 * @description: ArrayBinaryHeap
 **/
public class ArrayBinaryHeap {
    private int[] arr;

    public ArrayBinaryHeap(int[] arr) {
        this.arr = arr;
    }

    public void buildHeap() {
        buildHeap(arr.length);
    }

    /**
     * 从最后一个非叶子节点开始遍历的向下调整
     */
    public void buildHeap(int length) {
        int lastIndex = length - 1;
        int lastNotLeafIndex = (lastIndex - 1) / 2;
        for (int i = lastNotLeafIndex; i >= 0; i--) {
            downAdjust(i, length);
        }
    }

    /**
     * 将最后一个元素向上调整到正确的位置
     * 找到最后一个元素，与它的父节点比较，如果父节点小，父节点向下
     * 最后一个元素继续向上比较，直到比父节点小，或者成为根节点
     */
    public void upAdjust() {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = arr[childIndex];
        while (childIndex > 0 && temp > arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        arr[childIndex] = temp;
    }

    /**
     * 将parentIndex的元素向下调整到正确位置
     * 将parentIndex的元素temp与它的左右子节点中大的比较，如果parentIndex小的话
     * 将parentIndex设置为大的子节点的值，然后temp继续与刚才的子节点的左右子节点比较
     * 直到没有子节点了或者比子节点要大，最后将temp赋值给最后停止的child
     *
     * @param parentIndex
     * @param length
     */
    public void downAdjust(int parentIndex, int length) {
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 找到子节点中较大的
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            // 如果该元素比子节点大，遍历结束
            if (temp >= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }

    public void preOrder() {
        if (arr == null) {
            System.out.println("二叉树为空，不能遍历!");
            return;
        }
        preOrder(0);
    }

    /**
     * 当前节点->左子树->右子树
     */
    public void preOrder(int index) {
        System.out.printf(arr[index] + "\t");
        // 如果有左子节点，遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        // 如果有右子树，遍历
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
