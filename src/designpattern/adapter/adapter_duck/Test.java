package designpattern.adapter.adapter_duck;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/3 21:30
 */
public class Test {
    public static void main(String[] args) {
        YellowDuck yellowDuck = new YellowDuck();
        RedTurkey redTurkey = new RedTurkey();
        //利用适配器伪装成鸭子的火鸡
        Duck turkeyAdapter = new TurkeyAdapter(redTurkey);
        System.out.println("小黄鸭");
        yellowDuck.fly();
        yellowDuck.quack();
        System.out.println("火鸡");
        redTurkey.fly();
        redTurkey.quack();
        System.out.println("转变成鸭子的火鸡");
        turkeyAdapter.fly();
        turkeyAdapter.quack();
    }
}
