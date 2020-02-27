package algorithm.nowcoder.huawei.pra13;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 21:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(getResult(s));
        }
    }

    public static String getResult(String s){
        StringBuilder str = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] s1 = s.split(" ");
        for (String s2:
             s1) {
            stack.push(s2);
        }
        while (!stack.isEmpty()){
            str.append(stack.pop()).append(" ");
        }
        return str.toString();
    }
}
