package algorithm.leetcode.practice.Topic_0003_无重复字符的最长字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author magic_罗璋
 * @date 2020/2/28 23:46
 */

public class Main1 {
    public static void main(String[] args) {
        System.out.println(length("aaabcxxaxadad"));
    }
    /*
            滑动窗口的办法
     */

     public static int length1(String s){
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 当遇到重复字符时，移动左指针
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
     }

    public static int length(String str){
        int n = str.length();
        Set<Character> set = new HashSet<>();
        int num = 0, j = 0, i = 0;
        while (i < n && j < n){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j++));
                num = Math.max(num,j-i);
            }else {
                set.remove(str.charAt(i++));
            }
        }
        return num;
    }
}

