package algorithm.leetcode.Topic_0027_移除元素;

import java.util.Arrays;

/**
 * @author magic_罗璋
 * @date 2020/2/29 11:01
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int count = count(nums, val);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

    public static int count(int[] nums,int val){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
