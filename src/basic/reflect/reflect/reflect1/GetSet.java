package basic.reflect.reflect.reflect1;

import java.lang.reflect.Method;

/**
 * TODO 获取类的get set方法
 *
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 22:41
 */
public class GetSet {
    public static void main(String[] args) {
        printGetSet(Methods.class);
    }

    public static void printGetSet(Class c) {
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if ("getClass".equals(method.getName())) continue;
            if (isGet(method)) System.out.printf("get: %s%n",method);
            if (isSet(method)) System.out.printf("set %s%n", method);
        }
    }

    private static boolean isGet(Method method) {
//        get方法肯定没有参数
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (!method.getName().startsWith("get")) {
            return false;
        }
        return !void.class.equals(method.getReturnType());
    }

    private static boolean isSet(Method method) {
//        set方法的参数肯定为1个
        if (method.getParameterTypes().length != 1) return false;
        return method.getName().startsWith("set");
    }
}
