package thread.chapter4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Piped
 * @date 2020/1/10 11:54
 */
public class Piped {
    static class Print extends Thread {
        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive = 0;
            while (true) {
                try {
                    if (((receive = reader.read()) != -1)) {
                        System.out.println((char) receive);
                    }
                    ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        try {
            writer.connect(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(new Print(reader),"Print");
        thread.start();
        int receive = 0;
        while ((receive = System.in.read())!= -1){
            writer.write(receive);
        }
        writer.close();
    }
}
