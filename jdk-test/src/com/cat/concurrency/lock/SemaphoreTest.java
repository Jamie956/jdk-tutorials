package com.cat.concurrency.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    /**
     * 信号量，分配n把共享锁
     */
    public static void main(String[] args) {
        //Thread Suspend
        Semaphore lock = new Semaphore(3);

        Runnable r = () -> {
            try {
                //Thread Suspend
                lock.acquire();
                System.out.println(String.format("Thread:[%s], Permits:[%s]", Thread.currentThread().getName(), lock.availablePermits()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Thread Suspend
                lock.release();
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
