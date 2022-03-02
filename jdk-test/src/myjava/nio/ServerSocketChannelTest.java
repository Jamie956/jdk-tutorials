package myjava.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ServerSocketChannelTest {
    @Test
    public void open() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
    }

    @Test
    public void validOps() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        int v = s.validOps();
    }

    @Test
    public void bind() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        InetSocketAddress ad = new InetSocketAddress(6666);
        s.bind(ad, 0);
    }

    @Test
    public void setOption() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        s.setOption(StandardSocketOptions.SO_RCVBUF, 3);
    }

    @Test
    public void socket() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        ServerSocket ss = s.socket();
    }

    @Test
    public void accept() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        InetSocketAddress ad = new InetSocketAddress(6666);
        s.bind(ad, 0);
        SocketChannel c = s.accept();
    }

    @Test
    public void acceptClient() throws IOException {
        SocketChannel s = SocketChannel.open(new InetSocketAddress(6666));
        s.write(ByteBuffer.allocate(6).put(new byte[]{97, 98}));
    }

    @Test
    public void getLocalAddress() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        InetSocketAddress ad = new InetSocketAddress(6666);
        s.bind(ad, 0);
        SocketAddress a = s.getLocalAddress();
    }


















    //----------------------------------

    //客户端
    @Test
    public void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        sChannel.shutdownOutput();

        //接收服务端的反馈
        int len = 0;
        while ((len = sChannel.read(buf)) != -1) {
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        inChannel.close();
        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(9898));
        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //发送反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}
