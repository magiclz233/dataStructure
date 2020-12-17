package designpattern.decorator;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName CondimentDecorator
 * @date 2020/1/3 15:38
 */
public abstract class CondimentDecorator extends Beverage {
    /**
     * 重写getDescription类
     * @return string
     */
    @Override
    public abstract String getDescription();
}
