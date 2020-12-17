package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName CanFly
 * @date 2020/1/2 14:47
 */
public class CanFly implements Fly {
    @Override
    public void fly() {
        System.out.println("会飞的鸭子");
    }
}
