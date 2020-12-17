package designpattern.factory.factory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Man
 * @date 2019/12/31 15:32
 */
public class Man implements Person {
    @Override
    public void say() {
        System.out.println("Man say ~~");
    }

    @Override
    public void run() {
        System.out.println("Man run ~~");
    }
}
