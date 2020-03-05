package basic.io.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 16:21
 */
public class FileToWriter {
    public static String file = "src/basic/file/filename.txt";
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(file));
            fileWriter.write("file writer \n fileName:Magic");
            fileWriter.close();
            System.out.println("FileWriter Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
