package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName FactoryProducer
 * @date 2020/1/2 10:40
 */
public class FactoryProducer {
    public static final String SEX = "sex";
    public static final String COLOR = "color";

    public static AbstractFactory getFactory(String factory){
        if(SEX.equals(factory)){
            return new SexFactory();
        }else if(COLOR.equals(factory)){
            return new ColorFactory();
        }else {
            return null;
        }
    }
}
