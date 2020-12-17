package designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Singer
 * @date 2020/1/6 16:04
 */
public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("唱歌");
    }

    public static void main(String[] args) {
        Singer singer = new Singer();
        ISinger o = (ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("向观众问好");
                Object invoke = method.invoke(singer, args);
                System.out.println("谢谢");
                return invoke;
            }
        });
        o.sing();
    }
}
