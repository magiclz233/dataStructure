package algorithm.leetcode.Topic_0026_删除排序数组中的重复项;

import java.util.Arrays;

/**
 * @author magic_罗璋
 * @date 2020/2/29 10:44
 */

public class Main {
    /*
        要求空间复杂度为O(1)
        方法： 双指针法
     */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int count = count(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

    public static int count(int[] nums){
        if(nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
