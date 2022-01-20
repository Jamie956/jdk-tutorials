package com.cat.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void lockTest() {
        //断点
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            //断点
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //断点，释放锁
                lock.unlock();
            }
        }).start();
    }

    /**
     * 3个线程使用同一个 ReentrantLock，上锁的代码其他线程不可进入
     */
    public static void lockTest2() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                //断点 suspend thread
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            //断点 suspend thread，此时已经有一条线程占用锁
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    public static void reLockWork(ReentrantLock lock) {

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "第一次嵌套内lock 的 state=" + lock.getHoldCount());

            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "第二次嵌套内lock 的 state=" + lock.getHoldCount());

            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "第三次嵌套内lock 的 state=" + lock.getHoldCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
            lock.unlock();
            System.out.println("锁释放");
        }

    }

    /**
     * 可重入锁
     * 同一个线程能进入 同一把锁 每一个锁住的代码块，通过CAS 修改state，嵌套的lock 会累计计算，嵌套外的会重置
     */
    public static void reLockWorkTest() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> reLockWork(lock)).start();
        new Thread(() -> reLockWork(lock)).start();
    }

    public static void twoLockWork(ReentrantLock a, ReentrantLock b) {
        try {
            a.lock();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " lock 1 i=" + i);
            }

            b.lock();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " lock 2 i=" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            a.unlock();
            b.unlock();
        }
    }

    /**
     * 必要要a锁 全部执行完
     */
    public static void twoLockTest() {
        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();
        new Thread(() -> twoLockWork(a, b)).start();
        new Thread(() -> twoLockWork(a, b)).start();
    }

    public static void twoLockWork2(ReentrantLock a, ReentrantLock b) {
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
    }

    /**
     * 第一条线程 跑完a lock 代码块，第二条线程开始跑a lock 代码块，第一条线程的 b lock 代码块 和 第二条线程的 a lock 交替执行
     */
    public static void twoLockTest2() {
        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();
        new Thread(() -> twoLockWork2(a, b)).start();
        new Thread(() -> twoLockWork2(a, b)).start();
    }

    public static void main(String[] args) {
//        lockTest();
//        lockTest2();
        reLockWorkTest();
    }
}
