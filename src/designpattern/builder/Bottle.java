package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Bottle
 * @date 2020/1/2 13:46
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "瓶子";
    }
}
