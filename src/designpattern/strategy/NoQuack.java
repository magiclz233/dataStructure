package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName NoQuack
 * @date 2020/1/2 14:46
 */
public class NoQuack implements Quack {
    @Override
    public void quack() {
        System.out.println("不会叫的鸭子");
    }
}
