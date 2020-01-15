package thread.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName CyclicBarrier
 * @date 2020/1/15 11:09
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        },"thread1").start();
        new Thread(new demo()).start();

        c.await();
        System.out.println(3);
    }
    static class demo implements Runnable{

        @Override
        public void run() {
//            try {
//                c.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
            System.out.println(2);
        }
    }
}
