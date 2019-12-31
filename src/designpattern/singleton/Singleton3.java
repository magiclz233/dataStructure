package designpattern.singleton;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 单例模式-饿汉式(线程安全)
 * @version 1.0
 * @ClassName SingletonPattern
 * @date 2019/12/30 19:42
 */
public class Singleton3 {
    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3(){

    }

    /*
    天生线程安全,无序加锁
    缺点:启动时即创建实例
     */

    public static Singleton3 getInstance(){

        return singleton3;
    }

}
