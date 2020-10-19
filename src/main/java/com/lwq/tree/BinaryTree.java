package com.lwq.tree;

/**
 * @author: LWQ
 * @create: 2020/10/12
 * @description: BinaryTree
 **/
public class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空！");
        } else {
            root.preOrder(root);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉树为空！");
        } else {
            root.infixOrder(root);
        }
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("二叉树为空！");
        } else {
            root.postOrder(root);
        }
    }


    public HeroNode preOrderSearch(int no) {
        if (root == null) {
            System.out.println("二叉树为空！");
            return null;
        } else {
            return root.preOrderSearch(root, no);
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root == null) {
            System.out.println("二叉树为空！");
            return null;
        } else {
            return root.infixOrderSearch(root, no);
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root == null) {
            System.out.println("二叉树为空！");
            return null;
        } else {
            return root.postOrderSearch(root, no);
        }
    }
}
