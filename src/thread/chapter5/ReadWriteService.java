package thread.chapter5;

/**
 * @author magic_lz
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
        System.out.println("main线程暂停2s");

    }

    public ReadWriteService(ReadWriteLockTest readWriteLockTest) {
        this.lockTest = readWriteLockTest;
    }

    @Override
    public void run() {
        lockTest.read();
        lockTest.write();
    }
}
