package basic.reflect.reflect.reflect1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO 反射获取私有字段和方法
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 22:00
 */
public class Declared {
    private String name;
    private String title;
    private int phone;

    public Declared(){
    }

    private String getPrivate(String s){
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Declared declared = new Declared();
//        访问私有属性
        Field[] fields = Declared.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(declared);
//            获取属性名字
            System.out.println(field.getName());
//            获取属性的值
            System.out.println(o);
        }
        Method getPrivate = Declared.class.getDeclaredMethod("getPrivate",String.class);
//        jvm编译允许通过
        getPrivate.setAccessible(true);
        String magic = (String) getPrivate.invoke(declared, "magic");
        System.out.println(getPrivate.getName());
        System.out.println(magic);
    }
}
