package com.lwq.queue;

/**
 * @author: LWQ
 * @create: 2020/10/7
 * @description: ArrayQueueDemo
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
            arrayQueue.addQueue(3);
            arrayQueue.addQueue(2);
            arrayQueue.addQueue(1);
            arrayQueue.addQueue(5);
            arrayQueue.showQueue();
            System.out.println();
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println(arrayQueue.getQueue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        ArrayQueue2 arrayQueue2 = new ArrayQueue2(3);
        arrayQueue2.addQueue(3);
        arrayQueue2.addQueue(2);
        arrayQueue2.addQueue(1);
        arrayQueue2.addQueue(5);
        arrayQueue2.showQueue();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(arrayQueue2.getQueue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
