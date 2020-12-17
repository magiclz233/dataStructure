package designpattern.factory.abstractfactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Woman
 * @date 2019/12/31 9:41
 */
public class Woman implements Sex {
    @Override
    public void sex() {
        System.out.println("abstractfactory Woman");
    }

    @Override
    public void say() {
        System.out.println("Woman say~~~");
    }

    @Override
    public void run() {
        System.out.println("Woman run~~~");
    }
}
