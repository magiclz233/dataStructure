package basic.reflect;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName BaseClass
 * @date 2020/1/7 20:12
 */
public class BaseClass {
    public int baseInt;

    private static void method3(){
        System.out.println("Method3");
    }

    public int method4(){
        System.out.println("Method4");
        return 0;
    }

    public static int method5(){
        System.out.println("Method5");
        return 0;
    }

    void method6(){
        System.out.println("Method6");
    }

    // piblic 的内部类
    public class BaseClassInnerClass{}

    // public 的枚举
    public enum BaseClassMemberEnum{}
}
