package designpattern.builder;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ChickBurger
 * @date 2020/1/2 13:58
 */
public class ChickBurger extends Burger {
    @Override
    public String name() {
        return "Chick Burger";
    }

    @Override
    public float price() {
        return 20.0f;
    }
}
