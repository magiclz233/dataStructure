package designpattern.proxy.demo1;

/**
 * @author magic_lz
 * Description TODO 糖果监视器
 * @version 1.0
 * @ClassName GumballMonitor
 * @date 2020/1/5 21:11
 */
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println(machine.getLocation());
//        System.out.println(machine.);
    }
}
