package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ZhiQuack
 * @date 2020/1/2 14:46
 */
public class ZhiQuack implements Quack {
    @Override
    public void quack() {
        System.out.println("吱吱叫的鸭子");
    }
}
