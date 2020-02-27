package algorithm.nowcoder.huawei.pra15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/27 14:54
 */
public class Main {
    public static void main(String[] args) {
        int num = Integer.parseInt(new Scanner(System.in).nextLine());
        List<Integer> list = new ArrayList<>();
        while (num !=0){
            list.add(num%2);
            num /= 2;
        }
//        list存储的二进制是反的
        int count = Collections.frequency(list, 1);
        System.out.println(count);
    }
}
