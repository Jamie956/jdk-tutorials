package com.cat.collection;

import org.junit.Test;

import java.util.*;

public class Main {

    /**
     * Debug ArrayList 无参构造 和 add 扩容机制
     */
    @Test
    public void arrayListInitTest() {
        //无参构造
        ArrayList<String> arrayList = new ArrayList<>();
        //扩容机制
        arrayList.add("1");
    }

    /**
     * Debug ArrayList 有参构造 和 add 扩容机制
     */
    @Test
    public void arrayListInitTest2() {
        //有参构造
        ArrayList<String> arrayList = new ArrayList<>(1);
        //
        arrayList.add("1");
    }

    /**
     * Debug ArrayList add 扩容
     */
    @Test
    public void arrayListResizeTest() {
        //构造函数
        ArrayList<String> arrayList = new ArrayList<>(3);
        //扩容机制
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        //需要扩容
        arrayList.add("1");
    }

    /**
     * Debug ArrayList delete
     */
    @Test
    public void arrayListDelTest() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        arrayList.remove(0);
        arrayList.remove("2");
    }

    /**
     * Debug ArrayList get
     */
    @Test
    public void arrayListGetTest() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");

        arrayList.get(1);
    }

    /**
     * Debug linkedList
     */
    @Test
    public void linkedListAddTest() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        linkedList.get(1);

        linkedList.remove(1);
    }

    @Test
    public void hashSetTest() {
        HashSet<Object> set = new HashSet<>(2);
        set.add("1");
        set.add("2");
        set.add("3");

        set.remove("2");
        set.contains("1");
    }

    public static void main(String[] args) {
        Map<Object, Object> hashMap = new HashMap<>();
        ArrayDeque<Object> dequeue = new ArrayDeque<>();

        TreeSet<Object> objects = new TreeSet<>();
    }
}
