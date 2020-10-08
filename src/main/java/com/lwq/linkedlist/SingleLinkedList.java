package com.lwq.linkedlist;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: SingleLinkedList
 **/
public class SingleLinkedList {
    // 头节点不存储数据
    private HeroNode head = new HeroNode(0, "", "");

    public SingleLinkedList() {
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 单链表添加，直接添加到最后一个节点后面
     * 需要先遍历列表，找到最后一个节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null || node.getNo() < temp.getNext().getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            }
            if (node.getNo() == temp.getNext().getNo()) {
                System.out.printf("节点%d在链表中已经存在，不能再次添加!", node.getNo());
                break;
            }
            temp = temp.getNext();
        }
    }

    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法删除！");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    public void update(HeroNode node) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法更新！");
            return;
        }

        HeroNode temp = head.getNext();
        boolean flag = false;
        while (temp != null) {
            if (temp.getNo() == node.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNickName(node.getNickName());
            temp.setName(node.getName());
        } else {
            System.out.printf("要更新的 %d 节点不存在\n", node.getNo());
        }

    }

    public void showList() {
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}