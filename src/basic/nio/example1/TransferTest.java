package basic.nio.example1;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName TransferTest
 * @date 2020/4/2 16:41
 */
public class TransferTest {
    public static void main(String[] args) throws IOException {
        transferFromOrTo();
    }

    public static void transferFromOrTo() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fromChannel = null;
        FileChannel toChannel = null;

        try {
            fileInputStream = new FileInputStream(new File("D:\\github\\download\\dataStructure\\src\\basic\\nio\\01_NIO基础.md"));

            fileOutputStream = new FileOutputStream(new File("D:\\github\\download\\dataStructure\\src\\basic\\nio\\01_NIO基础1.md"));

            fromChannel = fileInputStream.getChannel();
            toChannel = fileOutputStream.getChannel();

            //transferTo方法
            //fromChannel.transferTo(0, fromChannel.size(), toChannel);

            //transferFrom方法
            toChannel.transferFrom(fromChannel,0,fromChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
                if(fromChannel != null){
                    fromChannel.close();
                }
                if(toChannel != null){
                    toChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
