package com.lwq.avl;


/**
 * @author: LWQ
 * @create: 2020/10/23
 * @description: TreeNode
 **/
public class TreeNode {
    private int no;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int no) {
        this.no = no;
    }

    /**
     * 节点删除
     * 删除分为三种情况：
     * 1.删除叶子节点
     * 2.删除只有一个子节点的节点
     * 3.删除有两个子节点的节点
     * <p>
     * 删除叶子节点：
     * 直接将目标节点的父节点的子节点设置为null
     * <p>
     * 删除只有一个子节点的节点：
     * 1.目标节点为它的父节点的左节点
     * 1)目标节点有左子节点：parent.left=target.left
     * 2)目标节点有右子节点:parent.left=target.right
     * 2.目标节点为它的父节点的右节点
     * 1)目标节点有左子节点：parent.right=target.left
     * 2)目标节点有右子节点：parent.right=target.right
     * <p>
     * 删除两个子节点的节点：
     * 1.先找到目标节点
     * 2.找到目标节点的父节点
     * 3.找到目标节点右子树中的最小节点
     * 4.使用temp保存最小节点
     * 5.删除最小的节点
     * 6.将最小节点设置为目标节点
     *
     * @param no
     */
    public void delete(int no) {
        TreeNode target = find(no);
        if (target == null) {
            System.out.printf("节点%s不存在，无法删除!\n", no);
            return;
        }
        TreeNode parent = findParent(no);
        if (target.getLeftChild() == null && target.getRightChild() == null) {
            if (target == parent.getLeftChild()) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
            // 目标节点只有一个右子节点
        } else if (target.getLeftChild() == null && target.getRightChild() != null) {
            // 目标节点是自己父节点的左子节点
            if (parent.getLeftChild() == target) {
                parent.setLeftChild(target.getRightChild());
            } else {
                parent.setRightChild(target.getRightChild());
            }
        } else if (target.getLeftChild() != null & target.getRightChild() == null) {
            if (parent.getLeftChild() == target) {
                parent.setLeftChild(target.getLeftChild());
            } else {
                parent.setRightChild(target.getLeftChild());
            }
        } else {
            TreeNode min = target;
            while (min.getLeftChild() != null) {
                min = min.getLeftChild();
            }
            TreeNode minParent = findParent(min.getNo());
            minParent.setLeftChild(null);

            target.setNo(min.getNo());
        }
    }

    /**
     * 找到目标节点
     *
     * @param no
     * @return
     */
    public TreeNode find(int no) {
        if (this.getNo() < no) {
            if (this.getRightChild() != null) {
                return this.getRightChild().find(no);
            }
            return null;
        } else if (this.getNo() > no) {
            if (this.getLeftChild() != null) {
                return this.getLeftChild().find(no);
            }
            return null;
        } else {
            return this;
        }
    }

    public TreeNode findParent(int no) {
        if (this.getNo() > no) {
            // 没找到
            if (this.getLeftChild() == null) {
                return null;
            }
            if (this.getLeftChild().getNo() == no) {
                return this;
            } else {
                return this.getLeftChild().findParent(no);
            }
        } else if (this.getNo() < no) {
            if (this.getRightChild() == null) {
                return null;
            }
            if (this.getRightChild().getNo() == no) {
                return this;
            } else {
                return this.getRightChild().findParent(no);
            }
        } else {
            return null;
        }
    }


    /**
     * 从根节点开始遍历，如果比子节点小，判断能不能放在左子节点，不能就递归调用
     * 如果比子节点大，判断能不能放在右子节点，不能就递归调用
     */
    public void add(TreeNode treeNode) {
        if (this.getNo() > treeNode.getNo()) {
            if (this.getLeftChild() == null) {
                this.setLeftChild(treeNode);
            } else {
                this.getLeftChild().add(treeNode);
            }
        } else {
            if (this.getRightChild() == null) {
                this.setRightChild(treeNode);
            } else {
                this.getRightChild().add(treeNode);
            }
        }

        if (this.leftHeight() - this.rightHeight() > 1) {
            TreeNode leftChild = this.getLeftChild();
            if (leftChild.rightHeight() > leftChild.leftHeight()) {
                leftChild.leftRorate();
                this.rightRorate();
            } else {
                rightRorate();
            }
            return;
        }
        if (this.rightHeight() - this.leftHeight() > 1) {
            leftRorate();
        }

    }

    /**
     * 以当前节点为根节点进行左旋
     * 假设当前节点为A
     * 左旋步骤如下：
     * 1.新建一个和节点A内容一样的节点B
     * 2.B的左子节点设置为A的左子节点
     * 3.B的右子节点设置为A的右子节点的左子节点
     * 4.将A的内容修改为A的右子节点的内容（更新当前节点）
     * 5.将A的右子节点设置为A的右子节点的右子节点
     * 6.将A的左子节点设置为新节点
     */
    public void leftRorate() {
        TreeNode temp = new TreeNode(this.getNo());
        temp.setLeftChild(this.getLeftChild());
        temp.setRightChild(this.getRightChild().getLeftChild());
        this.setNo(this.getRightChild().getNo());
        this.setRightChild(this.getRightChild().getRightChild());
        this.setLeftChild(temp);
    }

    /**
     * 以当前节点为根节点进行右旋
     * 假设当前节点为A
     * 右旋步骤如下：
     * 1.新建一个和节点A内容一样的节点B
     * 2.B的左子节点设置为A的左子节点的右子节点
     * 3.B的右子节点设置为A的右子节点
     * 4.将A的内容修改为A的左子节点的内容（更新当前节点）
     * 5.将A的左子节点设置为A的左子节点的左子节点
     * 6.将A的右子节点设置为新节点
     */
    public void rightRorate() {
        TreeNode temp = new TreeNode(this.getNo());
        temp.setLeftChild(this.getLeftChild().getRightChild());
        temp.setRightChild(this.getRightChild());
        this.setNo(this.getLeftChild().getNo());
        this.setLeftChild(this.getLeftChild().getLeftChild());
        this.setRightChild(temp);
    }

    public int height() {
        return Math.max(this.getLeftChild() == null ? 0 : this.getLeftChild().height(),
                this.getRightChild() == null ? 0 : this.getRightChild().height()) + 1;
    }

    public int leftHeight() {
        if (this.getLeftChild() == null) {
            return 0;
        }
        return this.getLeftChild().height();
    }

    public int rightHeight() {
        if (this.getRightChild() == null) {
            return 0;
        }
        return this.getRightChild().height();
    }

    /**
     * 先序遍历
     * 先输出当前节点，再遍历左子树，最后遍历右子树
     */
    public void preOrder() {
        // 遍历当前节点
        System.out.println(this);
        // 如果左子节点不为null，遍历左子树
        if (this.leftChild != null) {
            this.leftChild.preOrder();
        }
        // 如果右子节点不为null，遍历右子树
        if (this.rightChild != null) {
            this.rightChild.preOrder();
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
     */
    public void postOrder() {
        if (this.leftChild != null) {
            this.leftChild.postOrder();
        }
        if (this.rightChild != null) {
            this.rightChild.postOrder();
        }
        System.out.println(this);
    }

    public int getNo() {
        return no;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }
}
