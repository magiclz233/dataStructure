package thread.concurrent_art.chapter1;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ConcurrencyTest
 * @date 2020/1/9 17:07
 */
public class ConcurrencyTest {
    public static final long COUNT = 1000000001;
    public static void main(String[] args) throws InterruptedException {
        /*
        你会发现100001次循环的情况下，串行运行比并发执行速度要快
        因为多线程的话，有线程的创建和线程之间切换的开销。
        所以在循环次数较少的情况下，多线程不一定更省时间
        当我改成1000000001的时候，可以发现多线程的循环时间已经比串行运行的时间快了
         */
        concurrency();
        serial();
    }
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(()->{
            int a = 0;
            for (long i = 0;i<COUNT;i++){
                a += 5;
            }
        });

        thread.start();

        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }

        long time = System.currentTimeMillis()-start;
        thread.join();
        System.out.println("concurrency:"+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0;i<COUNT;i++){
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"ms,b="+b+",a="+a);

    }
}
