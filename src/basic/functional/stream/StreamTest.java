package basic.functional.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author magic_lz
 * @version 1.0
 * @classname StreamTest
 * @date 2020/11/23 : 11:12
 */
public class StreamTest {
    public static void main(String[] args) {
        stream1();
    }
    public static void stream1(){
        List<String> list = Arrays.asList("a1","a2","b1","b2","c1","c2");
        list.stream()
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
