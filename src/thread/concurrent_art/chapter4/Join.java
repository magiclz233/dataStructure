package thread.concurrent_art.chapter4;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Join
 * @date 2020/1/10 12:14
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Demo(currentThread),"demo"+i);
            thread.start();
            currentThread = thread;
        }
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName()+"结束");
    }
    static class Demo implements Runnable{
        private Thread thread;
        public Demo(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }
    }
}
