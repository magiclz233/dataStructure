package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 16:38
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Sex getSex(String sex);

}
