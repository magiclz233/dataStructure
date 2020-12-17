package designpattern.proxy.demo1;

/**
 * @author magic_lz
 * Description TODO 口香糖机
 * @version 1.0
 * @ClassName GumballMachine
 * @date 2020/1/5 20:48
 */
public class GumballMachine {
    // 其他实例变量
    String location;
    int count;

    public GumballMachine(String location,int count){
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }
}
