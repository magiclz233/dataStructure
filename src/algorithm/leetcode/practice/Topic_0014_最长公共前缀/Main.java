package algorithm.leetcode.practice.Topic_0014_最长公共前缀;


/**
 * @author magic_罗璋
 * @date 2020/2/29 1:11
 */

public class Main {

    /*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
     */

    public static void main(String[] args) {
        String[] strs = new String[]{"qwer","qwdd","qwerd","qwerty"};
        System.out.println(longestCommonPrefix1(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        int index = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < index; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public static String longestCommonPrefix1(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longest(prefix,strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public static String longest(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        // 判断传入的两个字符串,如果同位置的字符相同  则index++
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index ++;
        }
        return str1.substring(0,index);
    }
}
