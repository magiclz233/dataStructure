package thread.sync;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Test
 * @date 2020/12/17 : 17:50
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread(),"thread1");
        Thread thread2 = new Thread(new MyThread(),"thread2");
        thread1.start();
        thread2.start();
    }
}
