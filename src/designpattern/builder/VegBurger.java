package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName VegBurger
 * @date 2020/1/2 13:56
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
