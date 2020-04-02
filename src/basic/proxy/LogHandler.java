package basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName LogHandler
 * @date 2020/3/31 15:51
 */
public class LogHandler implements InvocationHandler {
    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();

        InvocationHandler logHandler = new LogHandler(userService);

        UserService userService1 = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        userService1.select();
        userService1.insert();
    }

    //被代理的对象，实际方法的执行者
    Object target;

    public LogHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public void before(){
        System.out.println("before:"+ LocalDateTime.now());
    }

    public void after(){
        System.out.println("after:" + LocalDateTime.now());
    }

}
