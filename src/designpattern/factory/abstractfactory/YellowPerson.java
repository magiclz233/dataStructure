package designpattern.factory.abstractfactory;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName YellowPerson
 * @date 2019/12/31 16:38
 */
public class YellowPerson implements Color {
    @Override
    public void color() {
        System.out.println("YellowPerson");
    }
}
