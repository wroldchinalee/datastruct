package com.lwq.tree;

/**
 * @author: LWQ
 * @create: 2020/10/12
 * @description: BinaryTreeDemo
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 构建二叉树
        HeroNode heroNode1 = new HeroNode(1, "及时雨", "宋江");
        HeroNode heroNode2 = new HeroNode(2, "玉麒麟", "卢俊义");
        HeroNode heroNode3 = new HeroNode(3, "智多星", "吴用");
        HeroNode heroNode4 = new HeroNode(4, "入云龙", "公孙胜");
        HeroNode heroNode5 = new HeroNode(5, "大刀", "关胜");

        heroNode1.setLeftChild(heroNode2);
        heroNode1.setRightChild(heroNode3);
        heroNode3.setLeftChild(heroNode5);
        heroNode3.setRightChild(heroNode4);

        BinaryTree binaryTree = new BinaryTree(heroNode1);
        // 先序遍历
        System.out.println("先序遍历~~");
        // 1,2,3,5,4
        binaryTree.preOrder();
        // 2,1,5,3,4
        System.out.println("中序遍历~~");
        // 2,5,4,3,1
        binaryTree.infixOrder();
        System.out.println("后序遍历~~");
        binaryTree.postOrder();

        System.out.println("先序遍历查找~~");
        HeroNode preNode = binaryTree.preOrderSearch(5);
        if (preNode != null) {
            System.out.printf("找到节点:%d,姓名:%s\n", preNode.getNo(), preNode.getName());
        } else {
            System.out.printf("没有找到序号为%d的节点!\n", 5);
        }

        System.out.println("中序遍历查找~~");
        HeroNode infixNode = binaryTree.infixOrderSearch(5);
        if (infixNode != null) {
            System.out.printf("找到节点:%d,姓名:%s\n", infixNode.getNo(), infixNode.getName());
        } else {
            System.out.printf("没有找到序号为%d的节点!\n", 5);
        }

        System.out.println("后序遍历查找~~");
        HeroNode postNode = binaryTree.postOrderSearch(5);
        if (postNode != null) {
            System.out.printf("找到节点:%d,姓名:%s\n", postNode.getNo(), postNode.getName());
        } else {
            System.out.printf("没有找到序号为%d的节点!\n", 5);
        }

    }
}
