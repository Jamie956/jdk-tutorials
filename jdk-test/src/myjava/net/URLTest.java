package myjava.net;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

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

    @Test
    public void toString1() throws MalformedURLException {
        URL a = new URL("https://www.baidu.com");
        String s = a.toString();
    }

    @Test
    public void toURI() throws MalformedURLException, URISyntaxException {
        URL a = new URL("https://www.baidu.com");
        URI s = a.toURI();
    }

    @Test
    public void openConnection() throws IOException {
        URL a = new URL("https://www.baidu.com");
        URLConnection c = a.openConnection();
    }

    @Test
    public void openConnection2() throws IOException {
        URL a = new URL("https://www.baidu.com");
        //?
        URLConnection c = a.openConnection(new Proxy(Proxy.Type.DIRECT, null));
    }

    @Test
    public void openStream() throws IOException {
        URL a = new URL("https://www.baidu.com");
        InputStream in = a.openStream();
        InputStreamReader inr = new InputStreamReader(in, Charset.defaultCharset());
        BufferedReader br = new BufferedReader(inr);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String s = sb.toString();
    }

    @Test
    public void getContent() throws IOException {
        URL a = new URL("https://www.baidu.com");
        InputStream in = (InputStream) a.getContent();

        byte[] buf = new byte[1024];
        int read = -1;
        StringBuilder sb = new StringBuilder();
        while ((read = in.read(buf)) != -1) {
            sb.append(new String(buf, 0, read, Charset.defaultCharset()));
        }
        String s = sb.toString();
    }

    @Test
    public void getContent2() throws IOException {
        URL a = new URL("https://www.baidu.com");
        Class[] cs = {InputStream.class};
        InputStream in = (InputStream) a.getContent(cs);

        byte[] buf = new byte[1024];
        int read = -1;
        StringBuilder sb = new StringBuilder();
        while ((read = in.read(buf)) != -1) {
            sb.append(new String(buf, 0, read, Charset.defaultCharset()));
        }
        String s = sb.toString();
    }

    @Test
    public void setURLStreamHandlerFactory() throws IOException {
        URL a = new URL("https://www.baidu.com");
        a.setURLStreamHandlerFactory(null);
    }


}
