package myjava.lang;

import org.junit.Test;

public class IntegerTest {
    @Test
    public void var() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        Class<Integer> c = Integer.TYPE;
        String d = Integer.toString(12, 1);
    }

    @Test
    public void toUnsignedString() {
        String s = Integer.toUnsignedString(19, 6);
        String a = Integer.toUnsignedString(-19, 10);
    }

    @Test
    public void toHexString() {
        String s = Integer.toHexString(15);
    }

    @Test
    public void toOctalString() {
        String s = Integer.toOctalString(15);
    }

    @Test
    public void toBinaryString() {
        String s = Integer.toBinaryString(15);
    }

    @Test
    public void toString1() {
        String s = Integer.toString(15);
        String a = Integer.toString(-15);
    }

    @Test
    public void toUnsignedString1() {
        String s = Integer.toUnsignedString(15);
        String a = Integer.toUnsignedString(-15);
    }

    @Test
    public void parseInt() {
        int i = Integer.parseInt("123", 10);
        int j = Integer.parseInt("-123", 10);
        int a = Integer.parseInt("1111", 2);
    }

    @Test
    public void parseUnsignedInt() {
        int i = Integer.parseUnsignedInt("123", 10);
        int a = Integer.parseUnsignedInt("1111", 2);
    }

    @Test
    public void valueOf() {
        Integer i = Integer.valueOf("1111", 2);
    }

    @Test
    public void valueOf1() {
        Integer i = Integer.valueOf("1111");
    }

    @Test
    public void valueOf2() {
        Integer i = Integer.valueOf(122);
    }








































}
