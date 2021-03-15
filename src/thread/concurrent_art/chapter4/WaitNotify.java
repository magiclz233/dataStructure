package thread.concurrent_art.chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName WaitNotify
 * @date 2020/1/10 11:03
 */
public class WaitNotify {
    static boolean flag = true;
    static  Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(),"wait" );
        Thread notify = new Thread(new Notify(),"notify");
        wait.start();
        TimeUnit.SECONDS.sleep(1);
        notify.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread()+"flag is true + wait @"+
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag is false + running @"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+"Notify持有锁 + notify @"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock){
                System.out.println(Thread.currentThread()+"再次持有锁 + notify @"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
}
