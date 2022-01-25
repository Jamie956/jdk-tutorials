package com.cat.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    //Suspend Thread
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readLockTest() {
        Runnable r = () -> {
            //Suspend Thread
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            //Suspend Thread
            readLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " read " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    public void writeLockTest() {
        Runnable r = () -> {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            //Suspend Thread
            writeLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " write " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    public static void main(String[] args) {
        ReadWriteLockTest t = new ReadWriteLockTest();
        t.readLockTest();
        t.writeLockTest();
    }
}