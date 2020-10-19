package com.lwq.tree.threadedbinarytree;

import com.lwq.tree.HeroNode;

/**
 * @author: LWQ
 * @create: 2020/10/16
 * @description: ThreadedBinaryTree
 **/
public class ThreadedBinaryTree {
    // 根节点
    private RoleNode rootNode;
    // 前驱节点
    private RoleNode prevNode;


    public void threadedNodes() {
        if (rootNode == null) {
            System.out.println("二叉树为空，无法线索化!");
            return;
        }
        threadedNodes(rootNode);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        RoleNode node = rootNode;
        while (node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeftChild();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRightChild();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRightChild();

        }
    }

    /**
     * 中序遍历
     * 先遍历左子树，再输出当前节点，最后遍历右子树
     */
    public void infixOrder() {
        if (rootNode.getLeftChild() != null) {
            rootNode.getLeftChild().infixOrder();
        }
        System.out.println(rootNode);
        if (rootNode.getRightChild() != null) {
            rootNode.getRightChild().infixOrder();
        }
    }

    /**
     * 线索化
     * 中序线索化
     * 先对左子树进行线索化，再对当前节点进行线索化，最后对右子树进行线索化
     * 对当前节点线索化：如果左子节点为null，指向它的前驱节点
     * 如果它的前驱节点的右子节点为null，指向当前节点
     */
    public void threadedNodes(RoleNode roleNode) {
        // 线索化左子树
        if (roleNode.getLeftChild() != null) {
            threadedNodes(roleNode.getLeftChild());
        }
        if (roleNode.getLeftChild() == null) {
            roleNode.setLeftChild(prevNode);
            roleNode.setLeftType(1);
        }

        if (prevNode != null && prevNode.getRightChild() == null) {
            prevNode.setRightChild(roleNode);
            prevNode.setRightType(1);
        }
        prevNode = roleNode;
        // 线索化右子树
        if (roleNode.getRightChild() != null) {
            threadedNodes(roleNode.getRightChild());
        }
    }

    public void setRootNode(RoleNode rootNode) {
        this.rootNode = rootNode;
    }


}
