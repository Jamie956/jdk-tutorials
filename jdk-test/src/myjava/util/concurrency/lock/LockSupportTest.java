package myjava.util.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public void unparkTest() {
        Thread t1 = new Thread(() -> {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " park");
            //断点 suspend
            LockSupport.park(t);
        });

        Thread t2 = new Thread(() -> {
            System.out.println("wait to unpark");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t1.getName() + " unpark");
            //断点 suspend
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        LockSupportTest t = new LockSupportTest();
        t.unparkTest();
    }
}
