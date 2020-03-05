package basic.reflect.reflect.reflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**TODO 反射获取方法 构造函数
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 22:21
 */
public class Methods {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Methods m = new Methods();
        Class<Methods> mClass = Methods.class;
//        该类中声明的公有方法
        Method[] methods = mClass.getMethods();

        Arrays.stream(methods).forEach(method -> {
            System.out.println(method.getName());
//            获取传参类型
            System.out.println(Arrays.toString(method.getParameterTypes()));
//            获取返回值类型
            System.out.println(method.getReturnType());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        });

        Method setName = Methods.class.getMethod("setName", String.class);
//        如果方法是静态的，第一个参数传null
        setName.invoke(m, "magic");
        Method getName = Methods.class.getMethod("getName");
        String name = (String) getName.invoke(m);
        System.out.println(name);

//        获得构造函数
        Constructor<?>[] constructors = mClass.getConstructors();
        System.out.println("获取的构造函数列表");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.println("构造函数参数");
            System.out.println(Arrays.toString(parameterTypes));
        }

        Constructor<Methods> constructor = Methods.class.getConstructor(String.class, String.class, int.class);
        Methods me = constructor.newInstance("magic", "男", 23);
        System.out.println(Methods.class.getMethod("toString").invoke(m));
    }
    private String name;
    private String sex;
    private int age;

    public Methods(){
    }

    public Methods(String name,String sex, int age){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Methods{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Methods methods = (Methods) o;
        return age == methods.age &&
                Objects.equals(name, methods.name) &&
                Objects.equals(sex, methods.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}
