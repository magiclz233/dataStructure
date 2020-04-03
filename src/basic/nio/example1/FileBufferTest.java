package basic.nio.example1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FileBufferTest
 * @date 2020/4/2 11:47
 */
public class FileBufferTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\新建文本文档.txt", "r");

        FileChannel channel = accessFile.getChannel();

        //创建缓冲区，容量为48
        ByteBuffer buffer = ByteBuffer.allocate(48);

        //写入缓冲区数据
        int read = channel.read(buffer);

        while (read != -1){

            //翻转缓冲区为读功能
            buffer.flip();

            //缓冲区中和极限位置还有元素，while循环输出
            while (buffer.hasRemaining()){

                System.out.print((char) buffer.get());
            }

            //清空缓冲区
            buffer.clear();

            //将缓冲区由读取变成写入
            read = channel.read(buffer);
        }

        accessFile.close();
    }
}
