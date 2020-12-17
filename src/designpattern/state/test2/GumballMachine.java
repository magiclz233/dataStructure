package designpattern.state.test2;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName GumballMachine
 * @date 2020/1/6 12:04
 */
public class GumballMachine {
    State soldOutState;
    State soldState;
    State noQuarterState;
    State hasQuarterState;

    State state = soldOutState;

    int count = 0;

    public GumballMachine(int count){
        soldOutState =  new SoldOutState(this);
        soldState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        this.count = count;
        if(count >0){
            state = noQuarterState;
        }
    }

    void insertQuarter(){
        state.insertQuarter();
    }

    void ejectQuarter(){
        state.ejectQuarter();
    }

    void turnCrank(){
        state.turnCrank();
    }

    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("正在取出糖果");
        if(count != 0){
            count--;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }
}
