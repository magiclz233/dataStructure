package algorithm.offer.Topic_0045_把数组排成最小的数;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/6 : 16:08
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 30, 31, 21, 22}));
    }

    public static String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strings) {
            res.append(str);
        }
        return res.toString();
    }
}

/*
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
