package com.lwq.linkedlist;

/**
 * @author: LWQ
 * @create: 2020/10/8
 * @description: DoubleLinkedList
 **/
public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 单链表添加，直接添加到最后一个节点后面
     * 需要先遍历列表，找到最后一个节点
     *
     * @param node
     */
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);
    }

    public void addByOrder(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null || node.getNo() < temp.getNext().getNo()) {
                // 设置插入节点的后驱节点
                node.setNext(temp.getNext());
                // 设置后驱节点的前继节点为插入节点
                // 第一个添加的节点，没有后驱节点，只有头节点，这里判断一下
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(node);
                }
                // 设置插入节点的后驱节点为插入节点
                temp.setNext(node);
                // 设置插入节点的前继节点
                node.setPrev(temp);
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
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (temp != null) {
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            // 修改待删除节点的前继节点的后驱节点
            temp.getPrev().setNext(temp.getNext());
            // 修改但删除节点的后驱节点的前继节点
            temp.getNext().setPrev(temp.getPrev());
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    public void update(HeroNode2 node) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法更新！");
            return;
        }

        HeroNode2 temp = head.getNext();
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
        HeroNode2 temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void showListReverse() {
        if (head.getNext() == null) {
            System.out.println("链表为空!");
            return;
        }
        HeroNode2 temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        HeroNode2 last = temp;
        while (temp != head) {
            System.out.println(temp);
            temp = temp.getPrev();
        }
    }


}

class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 prev;
    private HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
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

    public HeroNode2 getPrev() {
        return prev;
    }

    public void setPrev(HeroNode2 prev) {
        this.prev = prev;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}