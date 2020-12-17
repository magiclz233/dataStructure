package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Pepsi
 * @date 2020/1/2 13:59
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi ColdDrink";
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
