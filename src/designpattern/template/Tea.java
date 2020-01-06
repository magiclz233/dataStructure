package designpattern.template;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Tea
 * @date 2020/1/4 20:05
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("煮茶");
    }

    @Override
    void addCond() {
        System.out.println("加入柠檬");
    }
}
