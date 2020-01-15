package thread.chapter5;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ReadWriteService
 * @date 2020/1/13 15:42
 */
public class ReadWriteService extends Thread {
    private ReadWriteLockTest lockTest;

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockTest test = new ReadWriteLockTest();
        ReadWriteService service = new ReadWriteService(test);
        ReadWriteService service1 = new ReadWriteService(test);
        service.start();
        service1.start();
        Thread.sleep(2000);
        service.lockTest.write();
        service1.lockTest.write();
    }

    public ReadWriteService(ReadWriteLockTest readWriteLockTest) {
        this.lockTest = readWriteLockTest;
    }

    @Override
    public void run() {
        lockTest.read();
    }
}
