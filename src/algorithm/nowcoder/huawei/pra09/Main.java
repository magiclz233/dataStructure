package algorithm.nowcoder.huawei.pra09;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 21:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            Set<Character> integerSet = new LinkedHashSet<>(str.length());
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                integerSet.add(str.charAt(i));
            }
            for (Character character : integerSet) {
                stringBuilder.append(character);
            }
            System.out.println(stringBuilder);
        }
    }
}
