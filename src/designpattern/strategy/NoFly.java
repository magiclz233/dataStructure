package designpattern.strategy;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName NoFly
 * @date 2020/1/2 14:48
 */
public class NoFly implements Fly {
    @Override
    public void fly() {
        System.out.println("不会飞的鸭子");
    }
}
