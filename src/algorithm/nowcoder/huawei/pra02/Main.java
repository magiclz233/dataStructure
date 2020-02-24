package algorithm.nowcoder.huawei.pra02;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname HavingCount
 * @description TODO
 * @date 2020/2/19 16:24
 */
public class Main {
    public static int havingCount(String str, String s){
        String[] split = str.split("");
        int count = 0;
        for (int i = 0;i<split.length;i++){
            if(s.equals(split[i])){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String s = String.valueOf(scanner.nextLine().charAt(0));
        int i = havingCount(str, s);
        System.out.println(i);
    }
}
