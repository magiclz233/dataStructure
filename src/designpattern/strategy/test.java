package designpattern.strategy;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName test
 * @date 2020/1/2 15:23
 */
public class test {
    public static void main(String[] args){
      Duck duck = new NormalDuck();
      duck.performFly();
      duck.performQuack();
      duck.display();
    }
}
