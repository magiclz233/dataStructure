package designpattern.decorator;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName BlackBeverage
 * @date 2020/1/3 15:40
 */
public class BlackBeverage extends Beverage {

    public BlackBeverage(){
        setDescription("黑咖啡");
    }
    @Override
    public double cost() {
        return 2.00;
    }
}
