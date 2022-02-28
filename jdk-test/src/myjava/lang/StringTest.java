package myjava.lang;

import org.junit.Test;

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
    public void cons7() {
        byte[] arr = {96, 97, 98, 99, 100};
        String s = new String(arr, 1, 2, Charset.defaultCharset());
    }
}
