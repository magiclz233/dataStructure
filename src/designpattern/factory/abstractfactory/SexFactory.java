package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 16:40
 */
public class SexFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Sex getSex(String sex) {
        if(sex.isEmpty()){
            return null;
        }

        switch (sex){
            case "man":
                return new Man();
            case "woman":
                return new Woman();
            default:
                return null;
        }
    }
}
