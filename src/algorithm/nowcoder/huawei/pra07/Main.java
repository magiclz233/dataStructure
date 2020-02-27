package algorithm.nowcoder.huawei.pra07;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 20:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String num = scanner.nextLine();
            int f = num.indexOf(".");
            String number = num.substring(f+1, num.length());
            num = num.substring(0, f);
            if(Integer.parseInt(number) >= 5){
                System.out.println(Integer.parseInt(num)+1);
            }else {
                System.out.println(Integer.parseInt(num));
            }
        }
    }
}
