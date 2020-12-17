package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName NormalDuck
 * @date 2020/1/2 15:22
 */
public class NormalDuck extends Duck {

    public NormalDuck(){
        fly = new CanFly();
        quack = new GuaQuack();
    }
    @Override
    public void display() {
        System.out.println("正常小黄鸭");
    }
}
