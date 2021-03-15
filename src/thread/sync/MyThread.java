package thread.sync;

/**
 * @author magic_lz
 * @version 1.0
 * @classname MyThread
 * @date 2020/12/17 : 17:49
 */
public class MyThread implements Runnable {

    public Integer i = 100;
    @Override
    public void run() {
        test();
    }


    public void test(){
        synchronized (i.getClass()){
            i--;
            System.out.println(Thread.currentThread().getName()+"卖出去一张：剩余数量："+i);
        }
    }
}
