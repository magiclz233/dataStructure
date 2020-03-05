package algorithm.leetcode.Topic_0003_无重复字符的最长字符串;

import java.util.HashSet;

/**
 * @author magic_罗璋
 * @date 2020/2/28 23:29
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abcaabcxxa"));
    }

    /**
     * 暴力解法
     * 把其中每个字段都匹配一遍
     * @param str 传入的字符串
     * @return 无重复最长字符串
     */
    public static int lengthOfLongestSubString(String str){
        int n = str.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(allUnique(str,i,j)){
                    num = Math.max(num,j-i);
                }
            }
        }
        return num;
    }

    public static boolean allUnique(String s,int start,int end){
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
