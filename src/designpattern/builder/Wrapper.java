package designpattern.builder;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Wrapper
 * @date 2020/1/2 13:45
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "包装纸";
    }
}
