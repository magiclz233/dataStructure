package designpattern.state.test2;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName NoQuarterState
 * @date 2020/1/6 12:15
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("你投入了币");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没有投币");
    }

    @Override
    public void turnCrank() {
        System.out.println("你还没有投币");
    }

    @Override
    public void dispense() {
        System.out.println("你还没有投币");
    }
}
