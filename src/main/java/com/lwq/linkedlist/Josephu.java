package com.lwq.linkedlist;

/**
 * @author: LWQ
 * @create: 2020/10/8
 * @description: Josephu
 **/
public class Josephu {
    public static void main(String[] args) {
        SingleCircleLinkedList boys = new SingleCircleLinkedList(50);
        boys.init();
        boys.showList();

        boys.countBoy(1, 2);
    }

}

class SingleCircleLinkedList {
    private int maxSize;
    private BoyNode first;

    public SingleCircleLinkedList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void init() {
        if (maxSize <= 0) {
            System.out.println("初始化数量不合法！");
            return;
        }
        BoyNode currBoyNode = null;
        for (int i = 1; i <= maxSize; i++) {
            BoyNode boyNode = new BoyNode(i);
            if (first == null) {
                first = boyNode;
                boyNode.setNext(first);
                currBoyNode = first;
            } else {
                currBoyNode.setNext(boyNode);
                boyNode.setNext(first);
                currBoyNode = boyNode;
            }
        }
    }

    public void showList() {
        if (maxSize <= 0 || first == null) {
            System.out.println("链表为空!");
            return;
        }
        BoyNode currBoy = first;
        while (true) {
            System.out.println(currBoy);
            if (currBoy.getNext() == first) {
                break;
            }
            currBoy = currBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum) {
        if (startNo < 1 || startNo > maxSize) {
            System.out.println("startNo为%d不合法!");
            return;
        }

        if (first == null) {
            System.out.println("链表为空!");
            return;
        }
        // 1.先将helper的位置移动到first前面
        BoyNode helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        // 2.将first和helper移动k-1个位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 3.循环遍历链表，直到所有人出圈了
        while (true) {
            // 判断是否就剩一个小孩了
            if (first == helper) {
                System.out.printf("最后一个出圈的小孩是:%d \n", first.getNo());
                break;
            }
            // 将first和helper移动m-1个位置
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("出圈的小孩是:%d\n", first.getNo());
            // 删除first指向的节点
            first = first.getNext();
            helper.setNext(first);
        }

    }
}

class BoyNode {
    private int no;
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}