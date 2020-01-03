package designpattern.adapter.adapter_duck;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName TurkeyAdapter
 * @date 2020/1/3 21:26
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    /**
     * 很简单 用火鸡的方法实现Duck接口的方法
     */
    @Override
    public void quack() {
        turkey.quack();
    }

    @Override
    public void fly() {
        for (int i = 0;i< 5;i++){
            turkey.fly();
        }
    }
}
