package designpattern.decorator.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/15 17:56
 */
public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.dev.pcep.cloud");

        /*字节流*/
        InputStream in = url.openStream();
        /*字符流*/
        InputStreamReader inr = new InputStreamReader(in, StandardCharsets.UTF_8);
        /*缓存功能*/
        BufferedReader br = new BufferedReader(inr);

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
    }
}
