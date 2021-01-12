package algorithm.offer.Topic_0059_1_滑动窗口的最大值;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/7 : 17:23
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // 有问题

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < 1){
            return new int[0];
        }
        int n = nums.length - k + 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.max(Math.max(nums[i],nums[i+1]),nums[i+2]);
        }
        return arr;
    }



}

/*
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */