package com.lwq.tree;

/**
 * @author: LWQ
 * @create: 2020/10/19
 * @description: ArrayBinaryTreeDemo
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }

}

/**
 * 1.顺序存储二叉树通常只考虑完全二叉树
 * 2.第n个元素的左子节点为 2*n+1
 * 3.第n个元素的右子节点为 2*n+2
 * 4.第n个元素的父节点为 (n-1)/2
 */
class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
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
