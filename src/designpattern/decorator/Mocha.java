package designpattern.decorator;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Mocha
 * @date 2020/1/3 15:46
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage b){
        this.beverage = b;
    }
    @Override
    public String getDescription() {
        /*
        将你选择的咖啡和该配料都显示出来
         */
        return beverage.getDescription()+",加抹茶";
    }

    @Override
    public double cost() {
        /*
        将咖啡的钱和配料的钱加起来
         */
        return 1.00+beverage.cost();
    }
}
