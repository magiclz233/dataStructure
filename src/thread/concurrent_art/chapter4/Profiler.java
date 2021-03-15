package thread.concurrent_art.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Profiler
 * @date 2020/1/10 12:41
 */
public class Profiler {
    public static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    private static long initialValue(){
        return System.currentTimeMillis();
    }

    public static void begin(){
        initialValue();
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws InterruptedException {
      Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        long end = Profiler.end();
        System.out.println(end);


    }
}
