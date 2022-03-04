package myjava.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectionKeyTest {
    @Test
    public void client() throws IOException {
        SocketChannel s = SocketChannel.open(new InetSocketAddress(6666));
        s.configureBlocking(false);
        ByteBuffer bb = ByteBuffer.allocate(12);
        bb.put("abc".getBytes());
        bb.rewind();
        s.write(bb);
        s.close();
    }

    @Test
    public void channel() throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.configureBlocking(false);
        ss.bind(new InetSocketAddress(6666));

        Selector selector = Selector.open();
        ss.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                System.out.println("has key");
                SelectionKey next = iterator.next();
                iterator.remove();
                SelectableChannel channel = next.channel();
            }
        }
    }
}
