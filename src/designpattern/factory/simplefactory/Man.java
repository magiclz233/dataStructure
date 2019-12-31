package designpattern.factory.simplefactory;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Man
 * @date 2019/12/31 9:41
 */
public class Man implements Person {
    @Override
    public void say() {
        System.out.println("Man say!!!");
    }

    @Override
    public void run() {
        System.out.println("Man run!!!");
    }
}
