package com.cat.concurrency.lock;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQSTest extends AbstractQueuedSynchronizer {
    @Test
    public void getState1() {
        AQSTest a = new AQSTest();
        int state = a.getState();
    }

    @Test
    public void setState1() {
        AQSTest a = new AQSTest();
        a.setState(2);
    }

    @Test
    public void compareAndSetState1() {
        AQSTest a = new AQSTest();
        boolean b = a.compareAndSetState(0, 2);
    }

    @Test
    public void tryAcquire1() {
        AQSTest a = new AQSTest();
        boolean b = a.tryAcquire(2);
    }
}
