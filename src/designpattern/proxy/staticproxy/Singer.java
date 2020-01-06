package designpattern.proxy.staticproxy;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Singer
 * @date 2020/1/6 15:53
 */
public class Singer implements ISing {
    @Override
    public void sing() {
        System.out.println("唱歌");
    }
}
