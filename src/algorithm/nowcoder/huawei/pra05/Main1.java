package algorithm.nowcoder.huawei.pra05;

import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-22 19:13
 * Declaration: All Rights Reserved !!!
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(hexToDec(input));
        }
        scanner.close();
    }

    private static int hexToDec(String hex) {
        final int BASE = 16;
        int result = 0;

        for (int i = 2; i < hex.length(); i++) {
            System.out.println(hex.charAt(i));
            result = result * BASE + hexToNum(hex.charAt(i));
        }
        return result;
    }

    private static int hexToNum(char ch) {

        if (ch >= '0' && ch <= '9') {
            System.out.println(ch - '0'+"::::0-9");
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch - 'a' + 10+"::::a-z");
            return ch - 'a' + 10;
        } else {
            System.out.println(ch - 'A' + 10+"::::A-Z");
            return ch - 'A' + 10;
        }
    }
}
