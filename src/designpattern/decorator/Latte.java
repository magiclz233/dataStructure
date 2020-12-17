package designpattern.decorator;

/**
 * @author magic_lz
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
