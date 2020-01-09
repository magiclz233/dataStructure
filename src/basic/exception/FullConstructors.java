package basic.exception;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FullConstructors
 * @date 2020/1/6 20:37
 */
public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("MyException f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("MyException g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args){
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
