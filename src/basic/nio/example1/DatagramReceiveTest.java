package basic.nio.example1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * TODO DatagramChannel 服务端:接收客户端发送消息，收取到消息后，给发送方回应
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DatagramChannelTest
 * @date 2020/4/7 10:39
 */
public class DatagramReceiveTest {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9090));

        ByteBuffer buf = ByteBuffer.allocate(1024);
        byte[] bytes;

        while (true){
            //每次循环前，重置缓冲区
            buf.clear();

            SocketAddress socketAddress = channel.receive(buf);

            if(socketAddress != null){
                int position = buf.position();
                bytes = new byte[position];

                buf.flip();

                for (int i = 0; i < position; i++) {
                    bytes[i] = buf.get();
                }

                System.out.println("远程接收："+socketAddress.toString()+"~|~"+new String(bytes,"UTF-8"));

                //接收到消息然后给发送者返回

            }

        }
    }

    public static void sendReback(SocketAddress socketAddress,DatagramChannel channel) throws IOException {
        String message = "已通过9090接收到消息，感谢";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(message.getBytes("UTF-8"));

        buffer.flip();
        channel.send(buffer, socketAddress);
    }
}
