package designpattern.state.test2;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName State
 * @date 2020/1/6 12:02
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
