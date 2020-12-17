package basic.exception;

/**
 * @author magic_lz
 * Description TODO 如何使用Exception类型的方法
 * @version 1.0
 * @ClassName ExceptionMethods
 * @date 2020/1/7 11:54
 */
public class ExceptionMethods {
    public static void main(String[] args){
      try {
          throw new RuntimeException("My Exception");
      }catch (Exception e){
          System.out.println("Caught Exception");
          System.out.println("e.getMessage:::"+e.getMessage());
          System.out.println("e.getLocalizedMessage:::"+e.getLocalizedMessage());
          System.out.println("toString():" + e);
          System.out.println("printStackTrace():");
          e.printStackTrace(System.err);
      }
    }
}
