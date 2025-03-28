package algorithm.leetcode.practice.Topic_0009_回文数;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/6/10 : 9:54
 */
public class Main {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例:
     *      输入: 121
     *      输出: true
     *      输入: -121
     *      输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    /**
     * 思路 获取这个数的一半 反转与前一半进行比较,如果相等,则为回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){
        if(x == 0) return true;
        if(x < 0 || x % 10 == 0) return false;
        int b = 0;
        //b为反转的后半段数字 当while循环完成时 总长度为奇数,b= b/10 每次循环, b都会反向加一位, x则会短一位. 当最终
        // x <= b时,证明已经截取了一半的位置(总长度为偶数,截取了一半,总长度为奇数,截取了多一位)
        while(x > b){
            b = b*10 + x%10;
            x = x/10;
        }
        return x == b || x == b/10;
    }
}
