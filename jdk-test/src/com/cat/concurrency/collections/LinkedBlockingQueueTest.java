package com.cat.concurrency.collections;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("put 1" + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                queue.put(2);
                System.out.println("put 2" + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                queue.take();
                System.out.println("take" + queue);
                queue.put(3);
                System.out.println("put 3" + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
