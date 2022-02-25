package myjava.net;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpUtil {


    //--------------------- 场景模拟 ---------------------
    @Test
    public void get() {
        try {
            String link = "https://www.baidu.com/";
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, Charset.defaultCharset());
            BufferedReader br = new BufferedReader(isr);
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void post() {
        try {
            String path = "https://www.baidu.com/";
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(2000);
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            OutputStream outputStream = connection.getOutputStream();

            PrintWriter printWriter = new PrintWriter(outputStream);
            //post的参数 xx=xx&yy=yy
            printWriter.write("xx=xx&yy=yy");
            printWriter.flush();

            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
                bos.flush();
            }
            System.out.println(bos.toString("utf-8"));
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
