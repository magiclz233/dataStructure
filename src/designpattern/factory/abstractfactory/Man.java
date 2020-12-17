package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Man
 * @date 2019/12/31 16:22
 */
public class Man implements Sex {
    @Override
    public void sex() {
        System.out.println("abstractfactory Man");
    }

    @Override
    public void say() {
        System.out.println("abstractfactory Man say()~~ ");
    }

    @Override
    public void run() {
        System.out.println("abstractfactory Man run()~~ ");

    }
}
