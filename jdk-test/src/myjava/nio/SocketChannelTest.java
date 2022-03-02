package myjava.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
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
























}
