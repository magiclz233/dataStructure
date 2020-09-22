package algorithm.offer.Topic_0050_第一个只出现一次的字符;

import datastructure.tree.set.Map;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/22 : 17:02
 */
public class Main {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c,!map.containsKey(c));
        }
        for (char c : chars) {
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}

/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 */
