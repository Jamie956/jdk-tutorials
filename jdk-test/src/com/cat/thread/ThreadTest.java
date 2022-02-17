package com.cat.thread;

import org.junit.Test;

import java.util.Map;

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        sleep();
    }

    @Test
    public void currentThread() {
        Thread t = Thread.currentThread();
    }

    public static void yield() {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                Thread.yield();
            }
        };
        Thread t1 = new Thread(task, "低-优先度线程");
        Thread t2 = new Thread(task, "高-优先度线程");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

    public static void yieldLock() {
        Object lock = new Object();
        Runnable task = () -> {
            //yield不会释放锁
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":  " + i);
                    Thread.yield();
                }
            }
        };
        Thread t1 = new Thread(task, "低-优先度线程");
        Thread t2 = new Thread(task, "高-优先度线程");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

    public static void sleep() throws InterruptedException {
        Thread.sleep(100);
    }

    @Test
    public void sleep2() throws InterruptedException {
        Thread.sleep(100, 100);
    }

    @Test
    public void cons() {
        Thread thread = new Thread(new ThreadGroup("my-group"),
                () -> System.out.println("hi"), "my-thread", 0);
    }

    public static void start() {
        new Thread().start();
    }

    public static void run() {
        new Thread().run();
    }

    public static void interrupt() {
        new Thread().interrupt();
    }

    public static void interrupted() {
        Thread.interrupted();
    }

    public static void isInterrupted() {
        new Thread().isInterrupted();
    }

    public static void isAlive() {
        new Thread().isAlive();
    }

    public static void setPriority() {
        new Thread().setPriority(5);
    }

    public static void setName() {
        new Thread().setName("asas");
    }

    public static void activeCount() {
        int i = Thread.activeCount();
    }

    public static void enumerate() {
        Thread[] ts = new Thread[]{new Thread(), new Thread()};
        int i = Thread.enumerate(ts);
    }

    public static void join() throws InterruptedException {
        new Thread().join(100);
    }

    public static void join2() throws InterruptedException {
        new Thread().join(100, 100);
    }

    public static void dumpStack() {
        Thread.dumpStack();
    }

    public static void setDaemon() {
        new Thread().setDaemon(true);
    }

    public static void checkAccess() {
        new Thread().checkAccess();
    }

    public static void toString1() {
        new Thread().toString();
    }

    public static void getContextClassLoader() {
        new Thread().getContextClassLoader();
    }

    public static void setContextClassLoader() {
        new Thread().setContextClassLoader(ClassLoader.getSystemClassLoader());
    }
    public static void holdsLock() {
        Thread.holdsLock(new Object());
    }

    public static void getStackTrace() {
        StackTraceElement[] stackTrace = new Thread().getStackTrace();
    }

    public static void getAllStackTraces() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
    }

    public static void getState() {
        new Thread().getState();
    }

    public static void setDefaultUncaughtExceptionHandler() {
//        Thread.setDefaultUncaughtExceptionHandler();
    }

    public static void setUncaughtExceptionHandler() {
//        new Thread().setUncaughtExceptionHandler();
    }

}
