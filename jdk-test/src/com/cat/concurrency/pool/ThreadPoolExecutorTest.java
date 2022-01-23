package com.cat.concurrency.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * - 任务数 < 核心corePoolSize，新建一个线程执行当前任务
 * - 任务数>corePoolSize，任务加入阻塞队列 blockingQueue
 * - blockingQueue 满了，并且 任务数<maxPoolSize，新建一个线程执行当前任务
 * - blockingQueue 满了，并且 任务数>maxPoolSize，采取拒绝策略
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutorTest t = new ThreadPoolExecutorTest();
//        t.poolInitTest();
//        t.poolAddQueueTest();
//        t.poolMaxTest();
        t.poolRejectTest();
    }

    /**
     * 任务数<核心线程数corePoolSize，新建一个线程执行当前任务
     */
    public void poolInitTest() {
        //初始化变量
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        Runnable task = () -> {
            try {
                System.out.printf("thread:%s, pool:%s%n",
                        Thread.currentThread().getName(), pool.toString());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //线程数size < 核心corePoolSize，新建一个线程执行当前任务
        pool.execute(task);
        pool.execute(task);
        pool.shutdown();
    }

    /**
     * 任务数>corePoolSize，任务加入阻塞队列 blockingQueue
     */
    public void poolAddQueueTest() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1));

        Runnable task = () -> {
            try {
                System.out.printf("thread:%s, pool:%s%n",
                        Thread.currentThread().getName(), pool.toString());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        pool.execute(task);
        //任务数>corePoolSize，任务加入阻塞队列 blockingQueue
        pool.execute(task);
        System.out.println(pool.toString());
        pool.shutdown();
    }

    /**
     * blockingQueue 满了，并且 任务数<maxPoolSize，新建一个线程执行当前任务
     */
    public void poolMaxTest() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1));

        Runnable task = () -> {
            try {
                System.out.printf("thread:%s, pool:%s%n",
                        Thread.currentThread().getName(), pool.toString());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        pool.execute(task);
        pool.execute(task);
        //blockingQueue 满了，并且 任务数<maxPoolSize，新建一个线程执行当前任务
        pool.execute(task);
        System.out.println(pool.toString());
        pool.shutdown();
    }

    /**
     * blockingQueue 满了，并且 任务数>maxPoolSize，采取拒绝策略
     */
    public void poolRejectTest() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.AbortPolicy());

        Runnable task = () -> {
            try {
                System.out.printf("thread:%s, pool:%s%n",
                        Thread.currentThread().getName(), pool.toString());
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        pool.execute(task);
        pool.execute(task);
        System.out.println(pool.toString());
        //blockingQueue 满了，并且 任务数>maxPoolSize，采取拒绝策略
        pool.execute(task);
        pool.shutdown();
    }

    Callable<Integer> t = () -> {
        TimeUnit.SECONDS.sleep(2);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    };

    /**
     * FutureTask implements Runnable
     * ThreadPoolExecutor.submit(Runnable)
     */
    @Test
    public void fut() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, 3,
                1, TimeUnit.HOURS,
                new LinkedBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        FutureTask<Integer> futureTask = new FutureTask<>(t);
        pool.submit(futureTask);

        System.out.println(futureTask.get());
    }
}