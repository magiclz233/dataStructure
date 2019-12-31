package designpattern.factory.simplefactory;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Woman
 * @date 2019/12/31 9:41
 */
public class Woman implements Person {
    @Override
    public void say() {
        System.out.println("Woman say!!!");
    }

    @Override
    public void run() {
        System.out.println("Woman run!!!");
    }
}
