package algorithm.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author magic
 * @since 2025/3/28 10:00 
 */
public class Daily250328 {
    public static void main(String[] args) {
        String str = "abccdeeqaa";
        System.out.println(minimumLength(str));
    }

    /**
     * 2716. 最小化字符串长度
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的字符串 s ，重复执行下述操作 任意 次：
     *
     * 在字符串中选出一个下标 i ，并使 c 为字符串下标 i 处的字符。并在 i 左侧（如果有）和 右侧（如果有）各 删除 一个距离 i 最近 的字符 c 。
     * 请你通过执行上述操作任意次，使 s 的长度 最小化 。
     *
     * 返回一个表示 最小化 字符串的长度的整数。
     *
     * 示例 1：
     *
     * 输入：s = "aaabc"
     * 输出：3
     * 解释：在这个示例中，s 等于 "aaabc" 。我们可以选择位于下标 1 处的字符 'a' 开始。接着删除下标 1 左侧最近的那个 'a'（位于下标 0）以及下标 1
     * 右侧最近的那个 'a'（位于下标 2）。执行操作后，字符串变为 "abc" 。继续对字符串执行任何操作都不会改变其长度。因此，最小化字符串的长度是 3 。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出：3
     * 解释：我们可以选择位于下标 1 处的字符 'b' 开始。下标 1 左侧不存在字符 'b' ，但右侧存在一个字符 'b'（位于下标 2），所以会删除位于下标 2 的字符 'b' 。
     * 执行操作后，字符串变为 "cbd" 。继续对字符串执行任何操作都不会改变其长度。因此，最小化字符串的长度是 3 。
     * 示例 3：
     *
     * 输入：s = "dddaaa"
     * 输出：2
     * 解释：我们可以选择位于下标 1 处的字符 'd' 开始。接着删除下标 1 左侧最近的那个 'd'（位于下标 0）以及下标 1 右侧最近的那个 'd'（位于下标 2）。
     * 执行操作后，字符串变为 "daaa" 。继续对新字符串执行操作，可以选择位于下标 2 的字符 'a' 。接着删除下标 2 左侧最近的那个 'a'（位于下标 1）以及下标 2 右
     * 侧最近的那个 'a'（位于下标 3）。执行操作后，字符串变为 "da" 。继续对字符串执行任何操作都不会改变其长度。因此，最小化字符串的长度是 2 。
     */
    public static int minimumLength(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.length();
    }

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }



}
