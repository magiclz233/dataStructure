package basic.reflect.reflect.reflect1.classloader;

/**
 * TODO 动态类加载
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/4 0:13
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = TestClass.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("basic.reflect.reflect.reflect1.classloader.TestClass");
        String name = aClass.getSimpleName();
        System.out.println(name);
    }
}
