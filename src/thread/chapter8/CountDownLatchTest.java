package thread.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName CountDownLatchTest
 * @date 2020/1/15 10:44
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
//        new Thread(() ->{
//           System.out.println(1);
//           c.countDown();
//           System.out.println(2);
//           c.countDown();
//        }).start();
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            Thread1 thread1 = new Thread1(countDownLatch);
            service.execute(thread1);
        }
        countDownLatch.await();
        System.out.println("main");
    }

    static class Thread1 implements Runnable{
        private CountDownLatch countDown;

        private Thread1(CountDownLatch countDown){
            this.countDown = countDown;
        }
        @Override
        public void run() {
            synchronized (countDown){
                countDown.countDown();
                System.out.println("Thread count = "+countDown.getCount());
            }
            try {
                countDown.await();
                System.out.println("concurrency counts = "+(100 - countDown.getCount()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
