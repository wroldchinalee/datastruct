package com.lwq.tree;

/**
 * @author: LWQ
 * @create: 2020/10/12
 * @description: HeroNode
 **/
public class HeroNode {
    private int no;
    private String nickName;
    private String name;
    private HeroNode leftChild;
    private HeroNode rightChild;

    public HeroNode(int no, String nickName, String name) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }

    /**
     * 先序遍历
     * 先输出当前节点，再遍历左子树，最后遍历右子树
     *
     * @param node
     */
    public void preOrder(HeroNode node) {
        // 遍历当前节点
        System.out.println(node);
        // 如果左子节点不为null，遍历左子树
        if (node.leftChild != null) {
            preOrder(node.leftChild);
        }
        // 如果右子节点不为null，遍历右子树
        if (node.rightChild != null) {
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     * 先遍历左子树，再输出当前节点，最后遍历右子树
     *
     * @param node
     */
    public void infixOrder(HeroNode node) {
        if (node.leftChild != null) {
            infixOrder(node.leftChild);
        }
        System.out.println(node);
        if (node.rightChild != null) {
            infixOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历
     * 先遍历左子树，再遍历右子树，最后输出当前节点
     *
     * @param node
     */
    public void postOrder(HeroNode node) {
        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }
        System.out.println(node);
    }

    public HeroNode preOrderSearch(HeroNode node, int no) {
        // 遍历当前节点
        if (node.getNo() == no) {
            return node;
        }
        HeroNode ret = null;
        // 如果左子节点不为null，遍历左子树
        if (node.leftChild != null) {
            ret = preOrderSearch(node.leftChild, no);
            if (ret != null) {
                return ret;
            }
        }
        // 如果右子节点不为null，遍历右子树
        if (node.rightChild != null) {
            ret = preOrderSearch(node.rightChild, no);
            if (ret != null) {
                return ret;
            }
        }
        return ret;
    }

    /**
     * @param node
     */
    public HeroNode infixOrderSearch(HeroNode node, int no) {
        HeroNode ret = null;
        if (node.leftChild != null) {
            ret = infixOrderSearch(node.leftChild, no);
            if (ret != null) {
                return ret;
            }
        }
        if (node.getNo() == no) {
            return node;
        }
        if (node.rightChild != null) {
            ret = infixOrderSearch(node.rightChild, no);
            if (ret != null) {
                return ret;
            }
        }
        return null;
    }

    /**
     * @param node
     */
    public HeroNode postOrderSearch(HeroNode node, int no) {
        HeroNode ret = null;
        if (node.leftChild != null) {
            ret = postOrderSearch(node.leftChild, no);
            if (ret != null) {
                return ret;
            }
        }
        if (node.rightChild != null) {
            ret = postOrderSearch(node.rightChild, no);
            if (ret != null) {
                return ret;
            }
        }
        if (node.getNo() == no) {
            return node;
        }
        return null;
    }

    public int getNo() {
        return no;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HeroNode leftChild) {
        this.leftChild = leftChild;
    }

    public HeroNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HeroNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
