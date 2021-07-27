package com.lwq.tree.binarysearchtree;


/**
 * @author: LWQ
 * @create: 2020/10/20
 * @description: BinarySearchTree
 * 二叉查找树
 * 当前节点比左子节点大，比右子节点小
 * {7, 3, 10, 12, 5, 1, 9, 2};
 **/
public class BinarySearchTree {
    private HeroNode root;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        HeroNode root = new HeroNode(7, "霹雳火", "秦明");
        binarySearchTree.preOrder();
        binarySearchTree.add(root);
        HeroNode heroNode3 = new HeroNode(3, "智多星", "吴用");
        HeroNode heroNode6 = new HeroNode(10, "小旋风", "柴进");
        HeroNode heroNode1 = new HeroNode(1, "及时雨", "宋江");
        HeroNode heroNode4 = new HeroNode(5, "大刀", "关胜");
        HeroNode heroNode5 = new HeroNode(9, "小李广", "花荣");
        HeroNode heroNode2 = new HeroNode(12, "美髯公", "朱仝");
        binarySearchTree.add(heroNode3);
        binarySearchTree.add(heroNode6);
        binarySearchTree.add(heroNode1);
        binarySearchTree.add(heroNode4);
        binarySearchTree.add(heroNode5);
        binarySearchTree.add(heroNode2);
        System.out.println("添加节点后~~");
        binarySearchTree.preOrder();

        HeroNode findNode = binarySearchTree.find(1);
        System.out.printf("节点1为:%s\n", findNode);
        HeroNode parentNode = binarySearchTree.findParent(7);
        System.out.printf("找节点%s父节点的父节点为:%s~~\n", 7, parentNode);
        System.out.println("删除节点5~~");
        binarySearchTree.delete(5);
        binarySearchTree.preOrder();
        System.out.println("删除节点3~~");
        binarySearchTree.delete(3);
        binarySearchTree.preOrder();
        System.out.println("删除节点10~~");
        binarySearchTree.delete(10);
        binarySearchTree.preOrder();
        System.out.println("删除节点7~~");
        binarySearchTree.delete(7);
        binarySearchTree.preOrder();
        System.out.println("删除节点9~~");
        binarySearchTree.delete(9);
        binarySearchTree.preOrder();
        System.out.println("删除节点12~~");
        binarySearchTree.delete(12);
        binarySearchTree.preOrder();
        System.out.println("删除节点1~~");
        binarySearchTree.delete(1);
        binarySearchTree.preOrder();

    }

    public BinarySearchTree() {
    }

    public BinarySearchTree(HeroNode root) {
        this.root = root;
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
     *
     * @param no
     */
    public void delete(int no) {
        this.root.delete(no);
    }

    public HeroNode find(int no) {
        if (this.root == null) {
            return null;
        }
        return this.root.find(no);
    }

    public HeroNode findParent(int no) {
        if (this.root == null) {
            return null;
        }
        return this.root.findParent(no);
    }


    public void add(HeroNode heroNode) {
        if (heroNode == null) {
            System.out.println("待添加节点为空，不能添加!");
            return;
        }
        if (root == null) {
            this.root = heroNode;
        } else {
            this.root.add(heroNode);
        }
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空，不能遍历!");
            return;
        }
        this.root.preOrder();
    }
}

class HeroNode {
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
        HeroNode target = find(no);
        if (target == null) {
            System.out.printf("节点%s不存在，无法删除!\n", no);
            return;
        }
        HeroNode parent = findParent(no);
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
            HeroNode min = target;
            while (min.getLeftChild() != null) {
                min = min.getLeftChild();
            }
            HeroNode minParent = findParent(min.getNo());
            minParent.setLeftChild(null);

            target.setNo(min.getNo());
            target.setName(min.getName());
            target.setNickName(min.getNickName());
        }
    }

    /**
     * 找到目标节点
     *
     * @param no
     * @return
     */
    public HeroNode find(int no) {
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

    public HeroNode findParent(int no) {
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
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        if (this.getNo() > heroNode.getNo()) {
            if (this.getLeftChild() == null) {
                this.setLeftChild(heroNode);
            } else {
                this.getLeftChild().add(heroNode);
            }
        } else {
            if (this.getRightChild() == null) {
                this.setRightChild(heroNode);
            } else {
                this.getRightChild().add(heroNode);
            }
        }
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

    public void setNo(int no) {
        this.no = no;
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
