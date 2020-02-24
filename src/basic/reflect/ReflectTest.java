package basic.reflect;

import java.util.Arrays;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ReflectTest
 * @date 2020/1/7 20:13
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过类的静态变量获取Class对象
        Class<ConcreteClass> a = ConcreteClass.class;

        //通过实例化的getClass()方法获取class对象
        Class<? extends ConcreteClass> aClass = new ConcreteClass(7).getClass();

        //通过Class.forName获取
        Class<?> forName = Class.forName("basic.reflect.ConcreteClass");

        //打印类的相关信息
        System.out.println(forName.getCanonicalName());
        System.out.println(forName.getName());

        //获取超类
        Class<?> superclass = forName.getSuperclass();
        System.out.println(superclass);
        System.out.println(Object.class.getSuperclass());
        System.out.println(String[].class.getSuperclass());

        //获取公有的所有class
        Class<?>[] classes = forName.getClasses();
        System.out.println(Arrays.toString(classes));

        //获取自身声明的类getDeclaredClasses()

        Class<?>[] declaredClasses = forName.getDeclaredClasses();
        System.out.println(Arrays.toString(declaredClasses));

        /*
        原始类型的class,包装类型的TYPE
         */
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());
        Class<Double> doubleClass = Double.TYPE;
        System.out.println(doubleClass.getName());

        //数组类型的class示例
        Class<?> arrayClass = Class.forName("[D");
        System.out.println(arrayClass.getCanonicalName());
        arrayClass = Class.forName("[B");
        System.out.println(arrayClass.getCanonicalName());
        arrayClass = Class.forName("[S");
        System.out.println(arrayClass.getCanonicalName());
        arrayClass = Class.forName("[C");
        System.out.println(arrayClass.getCanonicalName());
        arrayClass = Class.forName("[F");
        System.out.println(arrayClass.getCanonicalName());
    }
}
