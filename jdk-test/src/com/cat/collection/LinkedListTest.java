package com.cat.collection;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {
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
}
