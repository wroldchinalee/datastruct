package com.lwq.linkedlist;

/**
 * @author: LWQ
 * @create: 2020/10/8
 * @description: DoubleLinkedListDemo
 **/
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建要给链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("原来链表的情况~~");
        doubleLinkedList.showList();

        //加入
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        System.out.println("增加后的链表情况~~");
        doubleLinkedList.showList();

        System.out.println("从尾到头打印链表的情况~~");
        doubleLinkedList.showListReverse();

        //测试修改节点的代码
        HeroNode2 newHeroNode = new HeroNode2(2, "小卢", "玉麒麟~~");
        doubleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        doubleLinkedList.showList();

        //删除一个节点
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(2);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.showList();
    }
}
