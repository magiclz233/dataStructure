package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 16:40
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color.isEmpty()){
            return null;
        }

        switch (color) {
            case "black":
                return new BlackPerson();
            case "white":
                return new WhitePerson();
            case "yellow":
                return new YellowPerson();
            default:
                return null;
        }
    }

    @Override
    public Sex getSex(String sex) {
        return null;
    }
}
