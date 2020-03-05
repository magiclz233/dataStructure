package algorithm.leetcode.Topic_0013_罗马数字转整数;

/**
 * @author magic_罗璋
 * @date 2020/2/29 0:08
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt(""));
    }

    public static int romanToInt(String s){
        int sum = 0;
        int start = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(start < num){
                sum -= start;
            }else {
                sum += start;
            }
            start = num;
        }
        sum += start;
        return sum;
    }

    public static int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }

    }
}
