package designpattern.factory.factory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactory
 * @date 2019/12/31 15:35
 */
public class ManFactory implements CreatePeople {
    @Override
    public Person create() {
        return new Man();
    }
}
