package com.cat.concurrency.collections;

import java.util.concurrent.CopyOnWriteArraySet;

public class COWArraySet {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

        Runnable r = () -> {
            for (int i = 1; i < 6; i++) {
                //Suspend Thread
                set.add(Thread.currentThread().getName() + "  " + i % 3);
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }

}
