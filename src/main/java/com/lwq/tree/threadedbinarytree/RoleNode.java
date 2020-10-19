package com.lwq.tree.threadedbinarytree;

/**
 * @author: LWQ
 * @create: 2020/10/16
 * @description: HeroNode
 **/
public class RoleNode {

    private int no;
    private String nickName;
    private String name;
    private RoleNode leftChild;
    private RoleNode rightChild;
    private int leftType;//0:左子节点 1:前驱节点
    private int rightType;//0:右子节点 2:后继节点

    public RoleNode(int no, String nickName) {
        this.no = no;
        this.nickName = nickName;
    }


    /**
     * 先序遍历
     * 先输出当前节点，再遍历左子树，最后遍历右子树
     *
     * @param node
     */
    public void preOrder(RoleNode node) {
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
     */
    public void infixOrder() {
        if (this.leftChild != null) {
            this.leftChild.infixOrder();
        }
        System.out.println(this);
        if (this.rightChild != null) {
            this.rightChild.infixOrder();
        }
    }

    /**
     * 后序遍历
     * 先遍历左子树，再遍历右子树，最后输出当前节点
     *
     * @param node
     */
    public void postOrder(RoleNode node) {
        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }
        System.out.println(node);
    }

    public RoleNode preOrderSearch(RoleNode node, int no) {
        // 遍历当前节点
        if (node.getNo() == no) {
            return node;
        }
        RoleNode ret = null;
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
    public RoleNode infixOrderSearch(RoleNode node, int no) {
        RoleNode ret = null;
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
    public RoleNode postOrderSearch(RoleNode node, int no) {
        RoleNode ret = null;
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

    public RoleNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RoleNode leftChild) {
        this.leftChild = leftChild;
    }

    public RoleNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RoleNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "RoleNode{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
