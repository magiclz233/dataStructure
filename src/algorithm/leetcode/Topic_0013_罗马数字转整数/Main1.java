package algorithm.leetcode.Topic_0013_罗马数字转整数;

/**
 * @author magic_罗璋
 * @date 2020/2/29 0:17
 */

public class Main1 {
    public static void main(String[] args) {
        System.out.println(new Main1().romanToInt("VIIIV"));
    }

    /*
        自己理解的方法
            执行用时 :4 ms, 在所有 Java 提交中击败了99.97%的用户
            内存消耗 :41.4 MB, 在所有 Java 提交中击败了5.01%的用户
        空间复杂度过高，不是好方法
     */

    public int romanToInt(String s){
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if(getValue(chars[i]) >= getValue(chars[i+1])){
                sum += getValue(chars[i]);
            }else {
                sum -= getValue(chars[i]);
            }
        }
        sum += getValue(chars[s.length()-1]);
        return sum;
    }

    public int getValue(char c){
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
