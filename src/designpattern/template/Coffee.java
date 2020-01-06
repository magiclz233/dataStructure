package designpattern.template;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Coffer
 * @date 2020/1/4 19:17
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("冲咖啡");
    }

    @Override
    void addCond() {
        System.out.println("加入糖和牛奶");
    }
}
