package basic.nio.example1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName FileChannelTest
 * @date 2020/4/2 11:33
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\新建文本文档.txt", "r");

        FileChannel channel = accessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int read = channel.read(buffer);

        while (read != -1){
            System.out.println("read:" + read);

            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }

        accessFile.close();
    }
}
