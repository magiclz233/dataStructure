package designpattern.observer.example3;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Observer
 * @date 2020/1/3 10:51
 */
public interface Observer {
    /**
     * 主题每次变动,调用update方法通知观察者
     * @param o 哪个主题的变化
     * @param arg 发送的内容
     */
    void update(Observable o,Object arg);
}
