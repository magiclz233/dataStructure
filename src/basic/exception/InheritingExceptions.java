package basic.exception;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName InheritingExceptions
 * @date 2020/1/6 20:27
 */
public class InheritingExceptions {
    void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        //抛出异常
        throw new SimpleException();
    }
    public static void main(String[] args){
      InheritingExceptions exception = new InheritingExceptions();
        try {
            exception.f();
        } catch (SimpleException e) {
//            System.out.println("SimpleException被使用");
            e.printStackTrace();
        }
    }
}
