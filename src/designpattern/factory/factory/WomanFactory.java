package designpattern.factory.factory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName WomanFactory
 * @date 2019/12/31 15:36
 */
public class WomanFactory implements CreatePeople {
    @Override
    public Person create() {
        return new Woman();
    }
}
