package thread.concurrent_art.chapter5.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ConditionWaitNotify
 * @date 2020/1/13 12:15
 */
public class ConditionWaitNotify {

    public static void main(String[] args){
      MyService service = new MyService();
      ThreadA thread = new ThreadA(service);
      thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signal();
    }

    static public class ThreadA extends Thread{
        private MyService service;

        public ThreadA(MyService service){
            this.service = service;
        }

        @Override
        public void run() {
            service.aWait();
        }
    }
    static public class MyService{
        private Lock lock = new ReentrantLock();

        public Condition condition = lock.newCondition();

        public void aWait(){
            lock.lock();
            try {
                System.out.println("aWait时间为::"+System.currentTimeMillis());
                condition.await();
                System.out.println("condition.await()完成,当await之后,必须得等到那边signal释放锁,这边才能继续");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void signal(){
            lock.lock();
            try {
                System.out.println("Signal的时间为::"+System.currentTimeMillis());
                condition.signal();
                Thread.sleep(1000);
                System.out.println("condition.signal()完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
