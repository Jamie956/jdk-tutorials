package myjava.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
    @Test
    public void server() throws IOException {
        ServerSocketChannel s = ServerSocketChannel.open();
        InetSocketAddress ad = new InetSocketAddress(6666);
        s.bind(ad, 0);
        while (true) {
            SocketChannel c = s.accept();
            ByteBuffer bb = ByteBuffer.allocate(12);
            bb.put(new byte[]{97, 98, 99});
            bb.clear();
            c.write(bb);
        }
    }

    @Test
    public void open() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        int i = s.validOps();
    }

    @Test
    public void bind() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open();
        s.bind(ad);
    }

    @Test
    public void setOption() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        s.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
    }

    @Test
    public void shutdownInput() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        s.shutdownInput();
    }

    @Test
    public void shutdownOutput() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        s.shutdownOutput();
    }

    @Test
    public void socket() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        Socket socket = s.socket();
    }

    @Test
    public void isConnected() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        boolean c = s.isConnected();
    }

    @Test
    public void isConnectionPending() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        boolean c = s.isConnectionPending();
    }

    @Test
    public void connect() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open();
        boolean c = s.connect(ad);
    }

    @Test
    public void finishConnect() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        boolean c = s.finishConnect();
    }

    @Test
    public void getRemoteAddress() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        SocketAddress rad = s.getRemoteAddress();
    }

    @Test
    public void read() throws IOException {
        InetSocketAddress ad = new InetSocketAddress(6666);
        SocketChannel s = SocketChannel.open(ad);
        ByteBuffer bb = ByteBuffer.allocate(12);
        s.read(bb);
    }











}
