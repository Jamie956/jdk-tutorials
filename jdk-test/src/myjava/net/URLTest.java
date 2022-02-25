package myjava.net;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void cons1() throws MalformedURLException {
        URL u = new URL("https://www.baidu.com/");
    }

    @Test
    public void cons2() throws MalformedURLException {
        URL u = new URL("   https://www.baidu.com/    ");
    }

    @Test
    public void getDefaultPort() throws MalformedURLException {
        URL u = new URL("https://www.baidu.com");
        int p = u.getDefaultPort();
    }

    @Test
    public void equals() throws MalformedURLException {
        URL a = new URL("https://www.baidu.com");
        URL b = new URL("https://www.baidu.com#aa");
        boolean c = a.equals(b);
    }

    @Test
    public void hashCode1() throws MalformedURLException {
        URL a = new URL("https://www.baidu.com");
        int h = a.hashCode();
    }

    @Test
    public void sameFile() throws MalformedURLException {
        URL a = new URL("https://www.baidu.com");
        URL b = new URL("https://www.baidu.com#aa");
        boolean c = a.sameFile(b);
    }



















































}
