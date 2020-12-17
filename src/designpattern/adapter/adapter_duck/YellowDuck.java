package designpattern.adapter.adapter_duck;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName YellowDuck
 * @date 2020/1/3 21:24
 */
public class YellowDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("小黄鸭呱呱叫");
    }

    @Override
    public void fly() {
        System.out.println("小黄鸭飞行");
    }
}
