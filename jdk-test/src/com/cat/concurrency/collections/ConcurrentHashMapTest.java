package com.cat.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> {
            //Suspend Thread
            map.put("k1", "v1");
        });
        Thread t2 = new Thread(() -> {
            //Suspend Thread
            map.put("k1", "v1");
        });
        t1.start();
        t2.start();
    }
}