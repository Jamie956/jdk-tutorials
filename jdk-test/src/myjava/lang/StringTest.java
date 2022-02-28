package myjava.lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringTest {
    @Test
    public void cons() {
        String s = new String();
    }

    @Test
    public void cons2() {
        String s = new String("111");
    }

    @Test
    public void cons3() {
        char[] arr = {'h', 'a', 'l', 'o'};
        String s = new String(arr);
    }

    @Test
    public void cons4() {
        char[] arr = {'h', 'a', 'l', 'o'};
        String s = new String(arr, 1, 2);
    }

    @Test
    public void cons5() {
        int[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr, 1, 2);
    }

    @Test
    public void cons6() {
        byte[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr, 0, 1, 2);
    }

    @Test
    public void cons7() throws UnsupportedEncodingException {
        byte[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr,0, arr.length, "UTF-8");
    }

    @Test
    public void cons8() {
        byte[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr,0, arr.length, Charset.defaultCharset());
    }

    @Test
    public void cons9() {
        byte[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr,0, arr.length);
    }

    @Test
    public void cons10() {
        StringBuilder sb = new StringBuilder();
        sb.append("as");
        String s = new String(sb);
    }

    @Test
    public void charAt() {
        String s = new String("abc");
        char c = s.charAt(1);
    }

    @Test
    public void getChars() {
        String s = new String("abc");
        char[] arr = new char[6];
        s.getChars(1, 3, arr, 0);
    }

    @Test
    public void getBytes() {
        String s = new String("abc");
        byte[] arr = new byte[6];
        s.getBytes(1, 3, arr, 0);
    }

    @Test
    public void getBytes1() throws UnsupportedEncodingException {
        String s = new String("abc");
        byte[] bytes = s.getBytes("UTF-8");
    }

    @Test
    public void equals()  {
        boolean b = "as".equals("as");
        boolean c = "as1".equals("a1s");
    }

    @Test
    public void contentEquals() {
        StringBuilder sb = new StringBuilder("asd");
        boolean b = "asd".contentEquals(sb);
    }



























}
