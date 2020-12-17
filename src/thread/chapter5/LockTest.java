package thread.chapter5;

import java.security.PublicKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Lock
 * @date 2020/1/13 11:49
 */
public class LockTest extends Thread {

    private MyService myService;

    public LockTest(MyService service){
        super();
        this.myService = service;
    }
    @Override
    public void run() {
        myService.testLock();
    }

    public static void main(String[] args){
      MyService service = new MyService();

      LockTest l1 = new LockTest(service);
      LockTest l2 = new LockTest(service);

      l1.start();
      l2.start();


    }
}
