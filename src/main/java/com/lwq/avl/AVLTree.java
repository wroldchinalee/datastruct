package com.lwq.avl;

/**
 * @author: LWQ
 * @create: 2020/10/23
 * @description: AVLTree
 **/
public class AVLTree {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个 AVLTree 对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new TreeNode(arr[i]));
        }
        // 遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }

    private TreeNode root;

    public void add(TreeNode treeNode) {
        if (this.root == null) {
            this.root = treeNode;
        } else {
            this.root.add(treeNode);
        }
    }

    public void infixOrder() {
        if (this.root == null) {
            System.out.println("AVL树为空，不能中序遍历!");
            return;
        }
        this.root.infixOrder();
    }

    public TreeNode getRoot() {
        return root;
    }
}
