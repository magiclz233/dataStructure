package basic.io.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 16:26
 */
public class FileToReader {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(FileToWriter.file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
