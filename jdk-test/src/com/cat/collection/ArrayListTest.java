package com.cat.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void newArrayListArg() {
        ArrayList<Integer> list = new ArrayList<>(6);
    }

    @Test
    public void newArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
    }

    @Test
    public void newArrayListByList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayList<Integer> list2 = new ArrayList<>(list);
    }

    @Test
    public void trimToSizeTest() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>(12);
        for (int i = 0; i < 14; i++) {
            list.add(1);
        }

        //数组实际长度
        Field f = list.getClass().getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] arr = (Object[]) f.get(list);
        System.out.println(arr.length);
        System.out.println(list.size());

        list.trimToSize();
        System.out.println(list.size());
    }

    @Test
    public void ensureCapacityTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(12);

        ArrayList<Integer> list2 = new ArrayList<>(3);
        list2.ensureCapacity(12);
    }
}
