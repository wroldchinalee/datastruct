package com.lwq.tree.threadedbinarytree;

/**
 * @author: LWQ
 * @create: 2020/10/16
 * @description: ThreadBinaryTreeDemo
 **/
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        RoleNode root = new RoleNode(1, "jack");
        RoleNode node1 = new RoleNode(3, "tom");
        RoleNode node2 = new RoleNode(6, "mike");

        root.setLeftChild(node1);
        root.setRightChild(node2);
        binaryTree.setRootNode(root);

        RoleNode node3 = new RoleNode(8, "林冲");
        RoleNode node4 = new RoleNode(10, "关胜");
        node1.setLeftChild(node3);
        node1.setRightChild(node4);
        RoleNode node5 = new RoleNode(14, "jerry");
        node2.setLeftChild(node5);

        System.out.println("---中序---");
        binaryTree.infixOrder();
//中序线索化二叉树
        binaryTree.threadedNodes();

        System.out.println("线索化完成之后~~");
        RoleNode afterHeroNode10 = node4.getRightChild();
        System.out.println(afterHeroNode10);// no=1 name=jack ok了

        RoleNode beforeHeroNode10 = node4.getLeftChild();
        System.out.println(beforeHeroNode10);
        System.out.println("遍历线索化二叉树");
        binaryTree.threadedList();
    }
}
