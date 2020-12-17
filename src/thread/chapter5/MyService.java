package thread.chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName MyService
 * @date 2020/1/13 12:00
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testLock(){
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("ThreadName="+Thread.currentThread().getName()+i);
            }
        }finally {
            lock.unlock();
        }

    }
}
