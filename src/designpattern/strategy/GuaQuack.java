package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName GuaQuack
 * @date 2020/1/2 14:46
 */
public class GuaQuack implements Quack {

    @Override
    public void quack() {
        System.out.println("呱呱叫的鸭子");
    }
}
