package basic.nio.example1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PipeTest
 * @date 2020/4/7 11:57
 */
public class PipeTest {

    public static void main(String[] args) throws IOException {
        //获取管道
        Pipe pipe = Pipe.open();

        //将缓冲区数据写入管道

        // 获取管道实例
        Pipe.SinkChannel sink = pipe.sink();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        buffer.put("发送数据test".getBytes("UTF-8"));

        buffer.flip();

        //将数据写入管道
        sink.write(buffer);

        //从管道读取数据
        Pipe.SourceChannel source = pipe.source();

        buffer.flip();

        int len = source.read(buffer);

        System.out.println(new String(buffer.array(),0,len));

        sink.close();
        source.close();

    }

}
