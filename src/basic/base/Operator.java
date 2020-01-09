package basic.base;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 运算符
 * @version 1.0
 * @ClassName Operator
 * @date 2020/1/9 10:17
 */
public class Operator {
    public static void main(String[] args){
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
    }
}
