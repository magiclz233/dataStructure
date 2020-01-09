package basic.functional;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RecursiveFactorial
 * @date 2020/1/8 16:50
 */
public class RecursiveFactorial {
    interface IntCall{
        int call(int arg);
    }
    static IntCall intCall;
    public static void main(String[] args){
      intCall = n->n == 0?1 : n * intCall.call(n-1);
      for (int i =1;i<10;i++){
          System.out.println(intCall.call(i));

      }
    }
}
