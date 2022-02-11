package com.cat.collection;

import org.junit.Test;

import java.util.HashSet;

public class HashSetTest {
    @Test
    public void hashSetTest() {
        HashSet<Object> set = new HashSet<>(2);
        set.add("1");
        set.add("2");
        set.add("3");

        set.remove("2");
        set.contains("1");
    }
}
