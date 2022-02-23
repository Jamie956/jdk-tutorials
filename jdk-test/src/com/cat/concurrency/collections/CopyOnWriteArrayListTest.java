package com.cat.concurrency.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    @Test
    public void cons() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
    }

    @Test
    public void cons2() {
        HashSet<Integer> s = new HashSet<>();
        s.add(2);
        s.add(6);
        s.add(7);
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>(s);
    }

    @Test
    public void cons3() {
        CopyOnWriteArrayList<Integer> s = new CopyOnWriteArrayList<>();
        s.add(2);
        s.add(6);
        s.add(7);
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>(s);
    }

    @Test
    public void cons4() {
        Integer[] arr = {4,7,9};
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>(arr);
    }

    @Test
    public void size() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(6);
        a.add(7);
        int i = a.size();
    }

    @Test
    public void contains() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(6);
        a.add(7);
        boolean b = a.contains(6);
    }

    @Test
    public void indexOf() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(6);
        a.add(7);
        int i = a.indexOf(6);
    }

    @Test
    public void indexOf2() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        a.add(7);
        int i = a.indexOf(6, 1);
    }

    @Test
    public void lastIndexOf() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        a.add(6);
        a.add(5);
        int i = a.lastIndexOf(6);
    }

    @Test
    public void lastIndexOf2() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        a.add(6);
        a.add(5);
        int i = a.lastIndexOf(6, 2);
    }

    @Test
    public void clone1() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        Object clone = a.clone();
    }

    @Test
    public void toArray() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        Object[] arr = a.toArray();
    }

    @Test
    public void toArray2() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        Integer[] arr = new Integer[4];
        Object[] r = a.toArray(arr);
    }

    @Test
    public void get() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(6);
        Integer i = a.get(2);
    }

    @Test
    public void set() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        Integer i = a.set(1, 9);
    }

    @Test
    public void add() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
    }

    @Test
    public void add2() {
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(2);
        a.add(1);
        a.add(1, 9);
    }

    @Test
    public void remove() {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<>();
        a.add("2");
        a.add("1");
        a.add("5");
        String v = a.remove(1);
    }

    @Test
    public void remove2() {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<>();
        a.add("2");
        a.add("1");
        a.add("5");
        boolean b = a.remove("1");
    }

    @Test
    public void addIfAbsent() {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<>();
        a.add("2");
        a.add("1");
        a.add("5");
        boolean b = a.addIfAbsent("1");
        boolean c = a.addIfAbsent("7");
    }

    @Test
    public void containsAll() {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<>();
        a.add("2");
        a.add("1");
        a.add("5");

        ArrayList<String> l = new ArrayList<>();
        l.add("2");
        l.add("1");
        l.add("5");
        l.add("7");

        boolean b = a.containsAll(l);
    }

    @Test
    public void removeAll() {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<>();
        a.add("2");
        a.add("1");
        a.add("5");

        ArrayList<String> l = new ArrayList<>();
        l.add("2");
        l.add("5");
        l.add("7");

        boolean b = a.removeAll(l);
    }





















    //----------------------- 场景模拟 -----------------------

//    public static void main(String[] args) throws InterruptedException {
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//
//        Runnable r = () -> {
//            for (int i = 0; i < 6; i++) {
//                String name = Thread.currentThread().getName() + "  " + i;
//                //Suspend Thread
//                list.add(name);
//                list.get(i);
//            }
//        };
//
//        Thread t1 = new Thread(r);
//        Thread t2 = new Thread(r);
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//    }
}