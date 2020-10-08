package com.lwq.queue;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: CircleQueue
 **/
public class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] data;

    public CircleQueue(int maxSize) {
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
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，读取失败");
        }
        int result = data[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", data[i]);
        }
    }

    public int headQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，读取失败");
        }
        return data[front];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
