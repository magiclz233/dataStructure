package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ColdDrink
 * @date 2020/1/2 13:49
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing(){
        return new Bottle();
    }

    @Override
    public abstract float price();
}
