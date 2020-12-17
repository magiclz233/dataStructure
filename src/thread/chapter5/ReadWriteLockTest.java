package thread.chapter5;

import thread.chapter5.condition.ConditionWaitNotify;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ReadWriteLockTest
 * @date 2020/1/13 15:31
 */
public class ReadWriteLockTest {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();

    }

    /**
     * 读读共享
     * 两个线程同时运行read方法，你会发现两个线程可以同时或者说是几乎同时运行lock()方法后面的代码，
     * 输出的两句话显示的时间一样。这样提高了程序的运行效率。
     */
    public void read() {
        lock.readLock().lock();
        try {
            System.out.println("获得读锁:" + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("读暂停3秒"+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 写写互斥
     * 两个线程同时运行read方法，你会发现同一时间只允许一个线程执行lock()方法后面的代码
     */
    public void write() {
        lock.writeLock().lock();
        try {
            System.out.println("获得写锁:" + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("写暂停3秒"+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }


}
