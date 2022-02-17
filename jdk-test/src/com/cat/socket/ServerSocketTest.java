package com.cat.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class ServerSocketTest {
    @Test
    public void cons() throws IOException {
        ServerSocket ss = new ServerSocket();
    }

    @Test
    public void cons3() throws IOException {
        ServerSocket ss = new ServerSocket(8989, 3, null);
    }


    @Test
    public void bind() throws IOException {
        ServerSocket ss = new ServerSocket();
        InetSocketAddress add = new InetSocketAddress(8989);
        ss.bind(add);
    }






































}
