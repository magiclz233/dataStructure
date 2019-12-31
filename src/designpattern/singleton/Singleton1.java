package designpattern.singleton;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 单例模式-懒汉式(非线程安全)
 * @version 1.0
 * @ClassName SingletonPattern
 * @date 2019/12/30 19:42
 */
public class Singleton1 {
    private static Singleton1 singleton1 = null;

    private Singleton1(){

    }

    /**
     * 优点：懒加载启动快，资源占用小，使用时才实例化，无锁。
     * 缺点：非线程安全。
     * @return Singleton1
     */
    public static Singleton1 getInstance(){
        if(singleton1 == null){
            return new Singleton1();
        }
        return singleton1;
    }

}
