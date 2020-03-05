package basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/4 11:02
 */
public class AopProxy {

    public static void main(String[] args) {
        CommonDao commonDao = new CommonDaoImpl();

        InvocationHandler handler = new MyInvocationHandler(commonDao);

        CommonDao proxy = (CommonDao) Proxy.newProxyInstance(commonDao.getClass().getClassLoader(), commonDao.getClass().getInterfaces(), handler);

        proxy.insert(1,2);

        proxy.delete(2,1);
    }
}
