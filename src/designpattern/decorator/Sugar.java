package designpattern.decorator;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Sugar
 * @date 2020/1/3 15:44
 */
public class Sugar extends CondimentDecorator {
    Beverage beverage;

    public Sugar(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",加糖";
    }

    /**
     * 必须重写父类的方法,不然直接使用父类的getSize方法获取不到值
     */
    @Override
    public int getSize(){
        return beverage.getSize();
    }
    @Override
    public double cost() {
        double cost = beverage.cost();
        if(getSize() == 1){//中杯
            cost += 1.00;
        }else if(getSize() == 2){ //大杯
            cost += 1.50;
        }else {//超大杯
            cost += 2.00;
        }
        return cost;
    }
}
