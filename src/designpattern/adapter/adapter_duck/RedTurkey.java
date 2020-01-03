package designpattern.adapter.adapter_duck;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RedTurkey
 * @date 2020/1/3 21:25
 */
public class RedTurkey implements Turkey {
    @Override
    public void quack() {
        System.out.println("火鸡蝈蝈叫");
    }

    @Override
    public void fly() {
        System.out.println("火鸡飞行-很短");
    }
}
