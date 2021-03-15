package thread.concurrent_art.chapter6;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ConcurrentLinkedQueue
 * @date 2020/1/14 11:10
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args){
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
