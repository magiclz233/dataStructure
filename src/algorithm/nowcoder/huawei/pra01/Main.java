package algorithm.nowcoder.huawei.pra01;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname LastStr
 * @description TODO
 * @date 2020/2/19 16:11
 */
public class Main {

    public static int lastStrLength(String str){
        String[] s = str.split(" ");
        return s[s.length-1].length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        System.out.println(s1[s1.length-1].length());
    }
}
