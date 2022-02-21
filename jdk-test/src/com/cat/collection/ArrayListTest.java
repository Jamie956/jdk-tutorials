package com.cat.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayListTest {
    @Test
    public void cons() {
        ArrayList<Integer> list = new ArrayList<>(6);
    }

    @Test
    public void cons2() {
        ArrayList<Integer> list = new ArrayList<>();
    }

    @Test
    public void cons3() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayList<Integer> list2 = new ArrayList<>(list);
    }

    @Test
    public void trimToSize() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>(12);
        for (int i = 0; i < 14; i++) {
            list.add(1);
        }

        Field f = list.getClass().getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] arr = (Object[]) f.get(list);
        System.out.println(arr.length);

        list.trimToSize();
        System.out.println(((Object[]) f.get(list)).length);
    }

    @Test
    public void ensureCapacity() {
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(12);

        ArrayList<Integer> list2 = new ArrayList<>(3);
        list2.ensureCapacity(12);
    }

    @Test
    public void indexOf() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int i = list.indexOf(2);
    }

    @Test
    public void lastIndexOf() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        int i = list.lastIndexOf(2);
    }

    @Test
    public void clone1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        Object clone = list.clone();
    }

    @Test
    public void toArray() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        list.toArray();
    }

    @Test
    public void toArray2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
//
        Integer[] arr = new Integer[]{2, 3};
        Integer[] is = list.toArray(arr);
    }

    @Test
    public void getTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        list.get(0);
    }

    @Test
    public void setTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(1, 9);
    }

    @Test
    public void addTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
    }

    @Test
    public void addTestByIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0, 2);
    }

    @Test
    public void removeTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        list.remove(0);
    }

    @Test
    public void removeTest2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("2");
    }

    @Test
    public void clearTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        list.clear();
    }

    @Test
    public void addAllTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        list.addAll(list2);
    }

    @Test
    public void addAllByIndexTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        list.addAll(1, list2);
    }

    @Test
    public void removeAllTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        list.removeAll(list2);
    }

    @Test
    public void retainAllTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        list.retainAll(list2);
    }

    @Test
    public void listIteratorTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> integerListIterator = list.listIterator(1);
    }

    @Test
    public void listIteratorByIndexTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> itr = list.listIterator();
        itr.add(9);
        itr.add(10);
        Integer previous = itr.previous();
        itr.set(5);
    }

    @Test
    public void iteratorTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        iterator.hasNext();
        iterator.next();
        iterator.remove();
        iterator.forEachRemaining((Integer e) -> System.out.println(e));
    }

    @Test
    public void subListTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integers = list.subList(0, 1);
    }

    @Test
    public void forEachTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void spliteratorTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Spliterator<Integer> spliterator = list.spliterator();
        Spliterator<Integer> integerSpliterator = spliterator.trySplit();
        spliterator.tryAdvance(e -> System.out.println(e));
    }

    @Test
    public void removeIfTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        boolean b = list.removeIf(e -> e % 2 == 0);
    }

    @Test
    public void replaceAllTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.replaceAll(e -> e * 2);
    }

    @Test
    public void sortTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(3);

        list.sort(Comparator.comparingInt(e -> e));
    }

    @Test
    public void sortNoComparatorTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(3);

        list.sort(null);
    }

    @Test
    public void sortNoComparator32Test() {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int j = 0; j < 33; j++) {
            int i = random.nextInt(100);
            list.add(i);
        }
        list.sort(null);
    }

}
