package algorithm.offer.Topic_0042_连续子数组的最大和;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/23 : 16:11
 */
public class Main {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        // dp[i-1]的值, i=0时,dp[i-1]=0
        int former = 0;
        int cur = nums[0];
        for (int num : nums) {
            // dp[i]
            cur = num;
            if(former > 0) cur += former;
            if(cur > max) max = cur;
            former = cur;
        }
        return max;
    }
}

/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 */
