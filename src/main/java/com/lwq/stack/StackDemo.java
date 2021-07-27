package com.lwq.stack;

/**
 * @author: LWQ
 * @create: 2020/10/24
 * @description: StackDemo
 **/
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        stack.list();
        for (int i = 0; i < 6; i++) {
            stack.pop();
        }
        stack.list();
    }
}
