package basic.nio.example1;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName SelectorTest
 * @date 2020/4/3 17:25
 */
public class SelectorTest {

    public static void main(String[] args){
        try {
            // 打开一个selector用来接收channel
            Selector selector = Selector.open();

            //测试，随便创建的
            SocketChannel socketChannel = SocketChannel.open();

            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_READ);

            while (true){
                int select = selector.select();

                if( select == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isAcceptable()){
                        //ServerSocketChannel接受了一个连接

                    }else if (next.isConnectable()){
                        //与远程服务器建立了连接。

                    }else if(next.isReadable()){
                        //读通道

                    }else if(next.isWritable()){
                        //写通道

                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
