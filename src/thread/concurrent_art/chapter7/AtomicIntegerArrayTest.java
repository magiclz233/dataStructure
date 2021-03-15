package thread.concurrent_art.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName AtomicIntegerArrayTest
 * @date 2020/1/14 15:59
 */
public class AtomicIntegerArrayTest {
    static int[] arr = new int[]{1,2,3,4};
    static AtomicIntegerArray array = new AtomicIntegerArray(arr);
    public static void main(String[] args){
        array.getAndSet(0,3);

        //3
        System.out.println(array.get(0));

        //1   不会影响原来的数组
        System.out.println(arr[0]);
    }
}
