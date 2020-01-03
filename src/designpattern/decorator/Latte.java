package designpattern.decorator;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Latte
 * @date 2020/1/3 15:41
 */
public class Latte extends Beverage {

    public Latte(){
        setDescription("拿铁");
    }
    @Override
    public double cost() {
        return 2.99;
    }
}
