package basic.functional.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/8 17:42
 */
public class Test {
    public static void main(String[] args) {
        new Random(40)
                .ints(1, 100)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);

        Stream.of(new Bubble(1),new Bubble(2),new Bubble(3))
                .forEach(System.out::println);
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);

        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(bubbles.stream().mapToInt(b -> b.i).sum());

    }
}
