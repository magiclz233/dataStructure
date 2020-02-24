package algorithm.nowcoder.huawei.pra05;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/23 17:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            translate(s);
        }
    }

    public static void translate(String s) {
        String[] strings = s.split("");
        int sum = 0;
        for (int i = 0;i<s.length();i++){
            String s1 = strings[s.length()-i-1].toUpperCase();
            switch (s1){
                case "A":
                    sum += 10 * Math.pow(16, i);
                    break;
                case "B":
                    sum += 11 * Math.pow(16, i);
                    break;
                case "C":
                    sum += 12 * Math.pow(16, i);
                    break;
                case "D":
                    sum += 13 * Math.pow(16, i);
                    break;
                case "E":
                    sum += 14 * Math.pow(16, i);
                    break;
                case "F":
                    sum += 15 * Math.pow(16, i);
                    break;
                default:
                    sum += Integer.parseInt(s1)*Math.pow(16, i);
            }
        }
        System.out.println(sum);
    }
}
