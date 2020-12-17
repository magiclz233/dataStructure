package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Coke
 * @date 2020/1/2 13:58
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 9.0f;
    }
}
