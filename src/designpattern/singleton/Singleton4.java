package designpattern.singleton;

/**
 * @author magic_lz
 * Description TODO 单例模式-静态类内部加载(线程安全)
 * @version 1.0
 * @ClassName SingletonPattern
 * @date 2019/12/30 19:42
 */
public class Singleton4 {
    private static class SingletonHolder{
        private static Singleton4 singleton4 = new Singleton4();
    }

    private Singleton4(){
    }

    /**
     * 使用内部类的好处是，静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载，
     * 达到了类似懒汉模式的效果，而这种方法又是线程安全的。
     * @return Singleton4
     */
    public static Singleton4 getInstance(){
        return SingletonHolder.singleton4;
    }

}
