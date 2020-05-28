package basic.nio.example1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * TODO 发送UDP包 并接收服务端返回
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DatagramSendTest
 * @date 2020/4/7 10:54
 */
public class DatagramSendTest {

    public static void main(String[] args) throws IOException {
        final DatagramChannel channel = DatagramChannel.open();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                byte[] b;

                while (true){
                    buffer.clear();

                    SocketAddress socketAddress = null;

                    try {
                        socketAddress = channel.receive(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(socketAddress != null){
                        int pos = buffer.position();

                        b = new byte[pos];

                        buffer.flip();

                        for (int i = 0; i < pos; i++) {
                            b[i] = buffer.get();
                        }

                        try {
                            System.out.println("远程接收："+socketAddress.toString()+"~|~"+new String(b,"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }).start();

        while (true){
            Scanner scanner = new Scanner(System.in);

            String next = scanner.nextLine();

            sendMessage(channel,next);
        }
    }

    public static void sendMessage(DatagramChannel channel,String mes) throws IOException {
        if(mes == null || mes.isEmpty()){
            return;
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(mes.getBytes("UTF-8"));
        buffer.flip();

        System.out.println("发送的消息为："+mes);
        int send = channel.send(buffer,new InetSocketAddress("localhost",9090));
    }
}
