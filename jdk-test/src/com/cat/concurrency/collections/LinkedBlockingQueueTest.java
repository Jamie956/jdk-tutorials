package com.cat.concurrency.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueTest {
    @Test
    public void cons1() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
    }

    @Test
    public void cons2() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(2);
    }

    @Test
    public void cons3() {
        ArrayList<String> l = new ArrayList<>();
        l.add("2");
        l.add("8");
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(l);
    }

    @Test
    public void put() throws InterruptedException {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
        q.put("5");
        q.put("4");
        q.put("9");
    }

    @Test
    public void offer() throws InterruptedException {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
        q.offer("5", 3, TimeUnit.SECONDS);
    }

    @Test
    public void offer2() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
        q.offer("5");
    }

    @Test
    public void take() throws InterruptedException {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
        q.offer("5");
        q.offer("7");
        q.offer("0");
        String r = q.take();
    }

    @Test
    public void poll() throws InterruptedException {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();
        q.offer("5");
        q.offer("7");
        q.offer("0");

        String a1 = q.poll(3, TimeUnit.SECONDS);
        String a2 = q.poll(3, TimeUnit.SECONDS);
        String a3 = q.poll(3, TimeUnit.SECONDS);
    }

    @Test
    public void poll2() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(3);
        q.offer("5");
        q.offer("7");
        q.offer("0");

        String a1 = q.poll();
        String a2 = q.poll();
        String a3 = q.poll();
    }

    @Test
    public void peek() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(3);
        q.offer("5");
        q.offer("7");
        q.offer("0");

        String a1 = q.peek();
    }

    @Test
    public void remove() {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(3);
        q.offer("5");
        q.offer("7");
        q.offer("0");

        boolean b = q.remove("7");
    }






































    //--------------------------- 场景模拟 ---------------------------
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
