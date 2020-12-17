package designpattern.state.test2;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName HasQuarterState
 * @date 2020/1/6 12:25
 */
public class HasQuarterState implements State {
    GumballMachine gumballMachine;
    HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("不能进行多次投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("撤回投币");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("转过把柄");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println();
    }
}
