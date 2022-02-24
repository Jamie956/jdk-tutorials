package com.cat.concurrency.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

    @Test
    public void cons1() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(5);
    }

    @Test
    public void cons2() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(5, true);
    }

    @Test
    public void cons3() {
        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(5, true, a);
    }

    @Test
    public void add() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        boolean a1 = q.add("2");
        boolean a2 = q.add("3");
        boolean a3 = q.add("4");
//        boolean a4 = q.add("5");
    }

    @Test
    public void offer() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        boolean a1 = q.offer("2");
    }

    @Test
    public void put() throws InterruptedException {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.put("2");
    }

    @Test
    public void offer2() throws InterruptedException {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        boolean b = q.offer("2", 3, TimeUnit.SECONDS);
    }

    @Test
    public void poll() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("2");
        String r = q.poll();
    }

    @Test
    public void take() throws InterruptedException {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("2");
        String r = q.take();
    }

    @Test
    public void poll1() throws InterruptedException {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("2");
        String r = q.poll(3, TimeUnit.SECONDS);
    }

    @Test
    public void peek() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("2");
        String a = q.peek();
    }

    @Test
    public void size() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("2");
        int a = q.size();
    }

    @Test
    public void remainingCapacity() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        int a = q.remainingCapacity();
    }

    @Test
    public void remove() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("5");
        q.add("7");
        boolean a = q.remove("5");
    }

    @Test
    public void contains() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("5");
        q.add("7");
        boolean b = q.contains("5");
    }

    @Test
    public void toArray() {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("5");
        q.add("7");
        Object[] arr = q.toArray();
    }























    //------------------------ 场景模拟 ------------------------

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
