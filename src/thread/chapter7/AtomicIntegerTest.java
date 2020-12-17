package thread.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName AtomicTest
 * @date 2020/1/14 15:31
 */
public class AtomicIntegerTest {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(2);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
