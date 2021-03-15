package thread.concurrent_art.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Interrupted
 * @date 2020/1/10 10:22
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Runnable target;
        Thread sleepRunner = new Thread(new SleepRunner(),"SleepRunner");
        sleepRunner.setDaemon(true);
        Thread busyRunner = new Thread(new BusyRunner(),"BusyRunner");
        busyRunner.setDaemon(true);
        sleepRunner.start();
        busyRunner.start();
        TimeUnit.SECONDS.sleep(5);

        sleepRunner.interrupt();
        busyRunner.interrupt();
        System.out.println(sleepRunner.isInterrupted());
        System.out.println(busyRunner.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){
            }
        }
    }
}
