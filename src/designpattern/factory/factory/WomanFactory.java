package designpattern.factory.factory;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
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
