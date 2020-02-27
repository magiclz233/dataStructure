package algorithm.nowcoder.huawei.pra11;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 21:51
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                String string = new StringBuilder(s).reverse().toString();
                System.out.println(string);
            }
    }
}
