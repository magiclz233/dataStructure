package basic.nio.example1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName AsyncFileChannelTest
 * @date 2020/4/7 12:10
 */
public class AsyncFileChannelTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\github\\download\\dataStructure\\src\\basic\\nio\\01_NIO基础.md");

        write(path);
    }


    public static void read(Path path) throws IOException {
        //open()的第一个参数是一个Path实体，指向我们需要操作的文件。
        //第二个参数是操作类型。上述示例中我们用的是StandardOpenOption.READ，表示以读的形式操作文件。
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(2861);
        long position = 0;
        Future<Integer> read = fileChannel.read(buffer, position);

        while (!read.isDone());
        buffer.flip();

        byte[] data = new byte[buffer.limit()] ;
        System.out.println(data.length);

        buffer.get(data);

        System.out.println(new String(data));
        buffer.clear();
    }
    public static void completionRead(Path path) throws IOException {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int position = 0;
    }

    public static void write(Path path) throws IOException {
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(48);

        long position = fileChannel.size();

        buffer.put("test data".getBytes());
        buffer.flip();

        Future<Integer> write = fileChannel.write(buffer, position);
        buffer.clear();

        while (!write.isDone());

        System.out.println("write done");
    }


}
