package com.lwq.queue;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: ArrayQueue
 **/
public class ArrayQueue2 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] data;

    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        data = new int[maxSize];
    }

    public void addQueue(int element) {
        //是否满了
        if (isFull()) {
            System.out.println("队列已满，添加失败！");
            return;
        }
        data[rear] = element;
        rear++;
    }

    public int getQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，读取失败");
        }
        return data[front++];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = 0; i < rear ; i++) {
            System.out.printf("%d\t", data[i]);
        }
    }

    public boolean isFull() {
        return rear == maxSize;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
