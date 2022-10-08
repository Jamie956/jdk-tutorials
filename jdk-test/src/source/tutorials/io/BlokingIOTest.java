package source.tutorials.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlokingIOTest {
    /**
     * 阻塞IO，服务端
     * 终端连接服务端：telnet 127.0.0.1 6666
     */
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService pool = Executors.newFixedThreadPool(10);

        while (true) {
            System.out.println("等待下一个客户端连接...");
            //accept 阻塞监听，等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("连接成功!");

            pool.execute(() -> {
                System.out.println("分配线程与新连接通信 " + Thread.currentThread().getName());

                //获取socket 输入流
                try (InputStream in = socket.getInputStream()) {
                    byte[] bytes = new byte[1024];
                    while (true) {
                        int length = in.read(bytes);
                        if (length != -1) {
                            System.out.println(new String(bytes, 0, length));
                        } else {
                            break;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        while (true) {

        }
    }

}
