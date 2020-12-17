package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName test
 * @date 2019/12/31 16:58
 */
public class test {
    public static void main(String[] args){
        AbstractFactory sexFactory = FactoryProducer.getFactory(FactoryProducer.SEX);
        Sex man = sexFactory.getSex("man");
        man.sex();

        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryProducer.COLOR);
        Color yellow = colorFactory.getColor("yellow");
        yellow.color();
    }
}
