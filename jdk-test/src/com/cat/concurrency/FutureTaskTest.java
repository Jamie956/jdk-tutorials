package com.cat.concurrency;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    @Test
    public void cons() {
        Callable<Integer> c = () -> {
            int a = 0;
            for (int i = 0; i < 100; i++) {
                a += i;
            }
            return a;
        };

        FutureTask<Integer> ft = new FutureTask<>(c);
    }

    @Test
    public void cons2() {
        Runnable r = () -> {
            int a = 0;
            for (int i = 0; i < 100; i++) {
                a += i;
            }
        };

        FutureTask<Integer> ft = new FutureTask<>(r, 1000);
    }

    @Test
    public void isCancelled() {
        Callable<Integer> c = () -> {
            int a = 0;
            for (int i = 0; i < 100; i++) {
                a += i;
            }
            return a;
        };

        FutureTask<Integer> ft = new FutureTask<>(c);
        ft.cancel(true);
        boolean b = ft.isCancelled();
    }

    @Test
    public void isDone() throws ExecutionException, InterruptedException {
        Callable<Integer> c = () -> {
            int a = 0;
            for (int i = 0; i < 5; i++) {
                a += i;
            }
            return a;
        };

        FutureTask<Integer> ft = new FutureTask<>(c);
        Integer i = ft.get();
        boolean b = ft.isDone();
    }

    @Test
    public void cancel() {
        Callable<Integer> c = () -> {
            int a = 0;
            for (int i = 0; i < 100; i++) {
                a += i;
            }
            return a;
        };

        FutureTask<Integer> ft = new FutureTask<>(c);
        ft.cancel(true);
    }





}
