package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ModelDuck
 * @date 2020/1/2 14:56
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        fly = new RocketFly();
        quack = new NoQuack();
    }
    @Override
    public void display() {
        System.out.println("模型鸭子");
    }
}
