package com.cat.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
//        lockTest();
//        lockTest2();
//        reLockTest();
//        twoLockTest();
        twoLockTest2();
    }

    public static void lockTest() {
        //Thread Suspend
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            //Thread Suspend
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Thread Suspend
                lock.unlock();
            }
        }).start();
    }

    /**
     * 3个线程使用同一个 ReentrantLock，上锁的代码其他线程不可进入
     */
    public static void lockTest2() {
        //Thread Suspend
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            //Thread Suspend
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Thread Suspend
                lock.unlock();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    /**
     * 可重入锁
     * 同一个线程能进入 同一把锁 每一个锁住的代码块
     */
    public static void reLockTest() {
        ReentrantLock lock = new ReentrantLock();

        Runnable r = () -> {
            String name = Thread.currentThread().getName();

            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println(name + "第一次嵌套内lock 的 state=" + lock.getHoldCount());

                //Thread Suspend
                lock.lock();
                Thread.sleep(1000);
                System.out.println(name + "第二次嵌套内lock 的 state=" + lock.getHoldCount());

                lock.lock();
                Thread.sleep(1000);
                System.out.println(name + "第三次嵌套内lock 的 state=" + lock.getHoldCount());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                lock.unlock();
                lock.unlock();
                System.out.println(name + " 锁释放");
            }
        };

        new Thread(r).start();
        new Thread(r).start();

    }

    /**
     * 必须要a锁 全部执行完
     */
    public static void twoLockTest() {
        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();

        Runnable r = () -> {
            try {
                a.lock();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " outer i=" + i);
                }

                b.lock();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " inner i=" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                a.unlock();
                b.unlock();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }

    /**
     * 第一条线程 跑完a lock 代码块，第二条线程开始跑a lock 代码块，
     * 第一条线程的 b lock 代码块 和 第二条线程的 a lock 交替执行
     */
    public static void twoLockTest2() {
        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();

        Runnable r = () -> {
            try {
                a.lock();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " lock 1 i=" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                a.unlock();
            }

            try {
                b.lock();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " lock 2 i=" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                b.unlock();
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
