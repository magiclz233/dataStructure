package algorithm.nowcoder.huawei.pra17;

import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/27 15:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            System.out.println(move(split));
        }
    }

    public static String move(String[] str) {
        int[] result = new int[2];
        for (String s : str) {
            if(s.matches("([ADWS])[0-9]{1,2}")){
                char c = s.charAt(0);
                int num = Integer.parseInt(s.substring(1));
                switch (c){
                    case 'A':
                        result[0] -=num;
                        break;
                    case 'D':
                        result[0] += num;
                        break;
                    case 'S':
                        result[1] -= num;
                        break;
                    case 'W':
                        result[1] += num;
                        break;
                    default:
                        System.out.println("传入正确的char");
                        break;
                }
            }
        }
        return result[0]+","+result[1];
    }
}
