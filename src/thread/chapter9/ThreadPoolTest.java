package thread.chapter9;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ThreadPoolTest
 * @date 2020/1/15 11:49
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        ThreadFactoryDemo factoryDemo = new ThreadFactoryDemo();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2
                , 5,10 , TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),factoryDemo, new MyIgnoreHandler());

        executor.prestartAllCoreThreads();

        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        executor.shutdown();
    }

     static class ThreadFactoryDemo implements ThreadFactory{

        private AtomicInteger num = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,"thread-"+num.getAndIncrement());
            System.out.println(t.getName()+"被建立");
            return t;
        }
    }

    static class MyIgnoreHandler implements RejectedExecutionHandler{

        MyIgnoreHandler(){}


        /**
         * Always throws RejectedExecutionException.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         * @throws RejectedExecutionException always
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        }
//        @Override
//        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            logs(r,executor);
//        }

        private void logs(Runnable r,ThreadPoolExecutor executor){
            System.out.println(r.toString()+"rejected");
            System.out.println(executor.getQueue());
        }
    }

    static class MyTask implements Runnable{
        private String name;

        MyTask(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public void run() {
            System.out.println(this.toString()+"正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
