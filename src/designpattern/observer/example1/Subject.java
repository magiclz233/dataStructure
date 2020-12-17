package designpattern.observer.example1;

/**
 * @author magic_lz
 * Description TODO 实现气象站
 * @version 1.0
 * @ClassName Subject
 * @date 2020/1/2 16:36
 */
public interface Subject {
    /**
     * 注册
     */
    void registerObserver(Observer o);


    void remove(Observer o);

    /**
     * 当主题方法改动，通知所有订阅的观察者
     */
    void notifyObservers();

}
