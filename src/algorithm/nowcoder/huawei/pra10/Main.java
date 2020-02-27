package algorithm.nowcoder.huawei.pra10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 21:43
 */
public class Main {
    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();
        System.out.println(getSize(line));

    }

    public static int getSize(String str){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(!list.contains(str.charAt(i))){
                list.add(str.charAt(i));
            }
        }
        return list.size();
    }
}
