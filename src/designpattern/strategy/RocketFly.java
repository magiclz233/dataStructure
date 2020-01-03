package designpattern.strategy;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RocketFly
 * @date 2020/1/2 15:18
 */
public class RocketFly implements Fly {
    @Override
    public void fly() {
        System.out.println("火箭发射器飞行。。");
    }
}
