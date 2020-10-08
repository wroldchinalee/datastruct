package com.lwq.linkedlist;

import java.util.Stack;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: SingleLinkedListDemo
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("原来链表的情况~~");
        singleLinkedList.showList();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        System.out.println("增加后的链表情况~~");
        singleLinkedList.showList();

        System.out.println("从尾到头打印链表的情况~~");
        reversePrint(singleLinkedList.getHead());

        reverse(singleLinkedList.getHead());
        System.out.println("反转后的链表情况~~");
        singleLinkedList.showList();
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        singleLinkedList.showList();

        System.out.println("获得倒数第二个节点");
        System.out.println(getLastNodeByIndex(singleLinkedList.getHead(), 2));
        System.out.println("获得倒数第四个节点");
        System.out.println(getLastNodeByIndex(singleLinkedList.getHead(), 4));

        //删除一个节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.showList();

        System.out.println();
        System.out.printf("链表中有效节点个数：%d", getLength(singleLinkedList.getHead()));


//		System.out.println("反转单链表~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();

//        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//        reversePrint(singleLinkedList.getHead());

/*
		//加入按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);

		//显示一把
		singleLinkedList.list();



		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();

		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

		//测试一下看看是否得到了倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/

        System.out.println();
        //合并两个有序链表
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode h1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode h2 = new HeroNode(3, "吴用", "智多星");
        HeroNode h3 = new HeroNode(5, "关胜", "大刀");
        HeroNode h4 = new HeroNode(9, "秦明", "霹雳火");
        singleLinkedList2.addByOrder(h1);
        singleLinkedList2.addByOrder(h2);
        singleLinkedList2.addByOrder(h3);
        singleLinkedList2.addByOrder(h4);
        System.out.println("添加后链表singleLinkedList2的情况~~");
        singleLinkedList2.showList();

        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        HeroNode h5 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode h6 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode h7 = new HeroNode(6, "林冲", "豹子头");
        HeroNode h8 = new HeroNode(8, "呼延灼", "双鞭");
        singleLinkedList3.addByOrder(h5);
        singleLinkedList3.addByOrder(h6);
        singleLinkedList3.addByOrder(h7);
        singleLinkedList3.addByOrder(h8);
        System.out.println("添加后链表singleLinkedList3的情况~~");
        singleLinkedList3.showList();

        SingleLinkedList mergeList = merge(singleLinkedList2, singleLinkedList3);
        System.out.println("合并后链表mergeList的情况~~");
        mergeList.showList();
    }

    public static int getLength(HeroNode headNode) {
        if (headNode.getNext() == null) {
            return 0;
        }
        HeroNode temp = headNode.getNext();
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public static HeroNode getLastNodeByIndex(HeroNode headNode, int index) {
        int length = getLength(headNode);
        if (index <= 0 || index > length) {
            return null;
        }
        int order = length - index;
        HeroNode temp = headNode.getNext();
        int count = 0;
        while (temp != null) {
            if (order == count) {
                break;
            }
            temp = temp.getNext();
            count++;
        }
        return temp;
    }

    public static void reverse(HeroNode headNode) {
        if (headNode.getNext() == null) {
            return;
        }
        HeroNode temp = headNode.getNext();
        HeroNode reverseNode = new HeroNode(0, "", "");
        while (temp != null) {
            headNode.setNext(temp.getNext());
            temp.setNext(reverseNode.getNext());
            reverseNode.setNext(temp);
            temp = headNode.getNext();
        }
        headNode.setNext(reverseNode.getNext());
    }

    public static void reversePrint(HeroNode head) {
        if (head.getNext() == null) {
            System.out.println("链表为空!");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.getNext();
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static SingleLinkedList merge(SingleLinkedList singleLinkedList1, SingleLinkedList singleLinkedList2) {
        HeroNode head1 = singleLinkedList1.getHead();
        HeroNode head2 = singleLinkedList2.getHead();
        if (head1.getNext() == null) {
            return singleLinkedList2;
        }
        if (head2.getNext() == null) {
            return singleLinkedList1;
        }
        SingleLinkedList mergeList = new SingleLinkedList();
        HeroNode temp1 = head1.getNext();
        HeroNode temp2 = head2.getNext();
        HeroNode mergeTail = mergeList.getHead();
        while (temp1 != null && temp2 != null) {
            if (temp1.getNo() <= temp2.getNo()) {
                mergeTail.setNext(temp1);
                mergeTail = temp1;
                temp1 = temp1.getNext();
            } else {
                mergeTail.setNext(temp2);
                mergeTail = temp2;
                temp2 = temp2.getNext();
            }
        }

        if (temp1 == null) {
            mergeTail.setNext(temp2);
        }
        if (temp2 == null) {
            mergeTail.setNext(temp1);
        }
        return mergeList;
    }
}
