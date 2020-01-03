package designpattern.factory.abstractfactory;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 16:38
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Sex getSex(String sex);

}
