package designpattern.singleton;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 单例模式-懒汉式(线程安全)
 * @version 1.0
 * @ClassName SingletonPattern
 * @date 2019/12/30 19:42
 */
public class Singleton2 {
    //private static Singleton2 singleton2 = null;
    private volatile static Singleton2 singleton2 = null;

    private Singleton2(){

    }

    //懒加载,线程安全,性能比加锁方法好
    public static Singleton2 getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(singleton2 == null){
            //同步块，线程安全的创建实例
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    return new Singleton2();
                }

            }
        }
        return singleton2;
    }
/**
 * 加锁的方法,并发性能较差,可以优化
 */
//    public static synchronized Singleton2 getInstance(){
//        if(singleton2 == null){
//            return new Singleton2();
//        }
//        return singleton2;
//    }



}
