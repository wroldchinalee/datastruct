package com.lwq.stack;

/**
 * @author: LWQ
 * @create: 2020/10/24
 * @description: Stack
 **/
public class Stack {
    private int size;
    private int[] datas;
    private int top;

    public Stack(int size) {
        datas = new int[size];
        this.size = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("栈满了，不能入栈！");
            return;
        }
        datas[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，不能出栈！");
        }
        return datas[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(datas[i]);
        }
    }
}
