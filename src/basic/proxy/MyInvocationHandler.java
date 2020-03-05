package basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/4 11:10
 */
public class MyInvocationHandler implements InvocationHandler {
    // 代理的真实对象
    private Object subject;

    public MyInvocationHandler(Object subject){
        this.subject = subject;
    }

    /**
     * 重写 invoke() 方法
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 代理方法传入的参数
     * @return 返回反射结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("方法【%s】开始执行，参数为【%s】\n",method.getName(), Arrays.asList(args));

        long start = System.currentTimeMillis();
        Object result = method.invoke(subject, args);
        long end = System.currentTimeMillis();
        System.out.printf("方法【%s】执行完成，运算结果为【%s】,用时【%s】毫秒 \n",method.getName(),result,end-start);
        return result;
    }
}
