package designpattern.state.test2;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName SoldState
 * @date 2020/1/6 12:03
 */
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println();
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
