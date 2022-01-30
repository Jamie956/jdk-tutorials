package com.cat.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {
    /*
        往满的数组阻塞队列 添加元素
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread t1 = new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("加入1");
                queue.put(2);
                System.out.println("加入2");
                //Suspend Thread，模拟队列元素满了，再往队列添加元素
                queue.put(3);
                System.out.println("加入3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                //Suspend Thread
                queue.take();
                System.out.println("取走第一个元素");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
