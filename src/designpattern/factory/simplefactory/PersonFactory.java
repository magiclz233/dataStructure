package designpattern.factory.simplefactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 14:30
 */
public class PersonFactory {

    /*
    简单工厂模式最大的优点在于实现对象的创建和对象的使用分离，
    将对象的创建交给专门的工厂类负责，但是其最大的缺点在于工厂类
    不够灵活，增加新的具体产品需要修改工厂类的判断逻辑代码，
    而且产品较多时，工厂方法代码将会非常复杂。
     */


    public static final String MAN = "man";
    public static final String WOMAN = "woman";

    public static Person create(String name){
        if(MAN.equals(name)){
            return new Man();
        }else if(WOMAN.equals(name)){
            return new Woman();
        }else {
            return null;
        }
    }
}
