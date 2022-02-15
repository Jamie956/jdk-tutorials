package com.cat.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapTest {
    @Test
    public void cons() {
        TreeMap<Object, Object> m = new TreeMap<>();
    }

    @Test
    public void cons2() {
        Comparator<Object> c = Comparator.comparingInt(e -> (int) e);
        TreeMap<Object, Object> m = new TreeMap<>(c);
    }

    @Test
    public void cons3() {
        HashMap<Object, Object> hm = new HashMap<>();
        hm.put("k1", "v1");
        hm.put("k2", "v2");
        TreeMap<Object, Object> m = new TreeMap<>(hm);
    }

    @Test
    public void cons4() {
        TreeMap<Object, Object> tm = new TreeMap<>();
        tm.put("k1", "v1");
        tm.put("k2", "v2");
        TreeMap<Object, Object> m = new TreeMap<>(tm);
    }

    @Test
    public void containsKey() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        boolean b = m.containsKey("k1");
    }

    @Test
    public void containsValue() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        boolean b = m.containsValue("v1");
    }

    @Test
    public void get() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        String v = m.get("k1");
    }

    @Test
    public void firstKey() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        String v = m.firstKey();
    }

    @Test
    public void lastKey() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        String v = m.lastKey();
    }

    @Test
    public void putAll() {
        TreeMap<String, String> m0 = new TreeMap<>();
        m0.put("k1", "v1");
        m0.put("k2", "v2");

        TreeMap<String, String> m = new TreeMap<>();
        m.putAll(m0);
    }

    @Test
    public void put() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
    }

    @Test
    public void remove() {
        TreeMap<String, String> m = new TreeMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");

        m.remove("k2");
    }




































}
