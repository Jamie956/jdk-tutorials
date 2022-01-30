package com.cat.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;

public class COWArrayList {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        Runnable r = () -> {
            for (int i = 0; i < 6; i++) {
                String name = Thread.currentThread().getName() + "  " + i;
                //Suspend Thread
                list.add(name);
                list.get(i);
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}