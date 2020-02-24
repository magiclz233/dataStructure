package algorithm.nowcoder.huawei.pra04;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/23 17:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            subStr(next);
        }
    }

    public static void subStr(String str){
        while (str.length()>= 8){
            System.out.println(str.substring(0, 8));
            str = str.substring(8);
        }
        if(str.length() > 0){
            str = str + "00000000";
            str = str.substring(0, 8);
            System.out.println(str);
        }
    }
}
