package designpattern.template;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 咖啡因类饮品超类
 * @version 1.0
 * @ClassName CaffeineBeverage
 * @date 2020/1/4 20:00
 */
public abstract class CoffeineBeverageHook {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCond()){
            addCond();
        }
    }

    /**
     * 钩子方法
     * @return boolean
     */
    boolean customerWantsCond(){
        return true;
    }
    /*
    冲泡(泡茶,冲咖啡等)
     */
    abstract void brew();
    /*
    加入调料(加糖,牛奶,柠檬等)
     */
    abstract void addCond();

    void boilWater(){
        System.out.println("把水煮沸");
    }
    void pourInCup(){
        System.out.println("饮料倒入杯子");
    }

    /**
     * 钩子方法,子类视情况决定要不要覆盖他
     */
    void hook(){}
}
