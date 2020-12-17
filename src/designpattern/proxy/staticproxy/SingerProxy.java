package designpattern.proxy.staticproxy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName SingerProxy
 * @date 2020/1/6 15:54
 */
public class SingerProxy implements ISing {
    //接收目标对象,以便调用sing方法
    private ISing target;
    public SingerProxy(ISing sing){
        this.target = sing;
    }

    //对目标对象的sing方法进行扩展
    @Override
    public void sing() {
        System.out.println("向观众问好!");
        target.sing();
        System.out.println("谢谢大家");
    }

    public static void main(String[] args){
        ISing s = new Singer();
        s.sing();
        ISing sing = new SingerProxy(s);
        sing.sing();
    }
}
