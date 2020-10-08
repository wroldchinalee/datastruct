package com.lwq.queue;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: ArrayQueue
 **/
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] data;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        data = new int[maxSize];
    }

    public void addQueue(int element) {
        //是否满了
        if (isFull()) {
            System.out.println("队列已满，添加失败！");
            return;
        }
        rear++;
        data[rear] = element;
    }

    public int getQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，读取失败");
        }
        front++;
        return data[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = 0; i < rear + 1; i++) {
            System.out.printf("%d\t", data[i]);
        }
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
