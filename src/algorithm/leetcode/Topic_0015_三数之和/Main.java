package algorithm.leetcode.Topic_0015_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/6/12 : 8:53
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //排序后第一个数字就大于0.则不可能相加等于0
            if(nums[i] > 0) break;
            // 去重复
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int L = i + 1;
            int R = len - 1;

            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                // 相加等于0, 三位数添加到list,并进行去重操作
                if(sum  == 0){
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if(sum < 0) L++;
                else R--;
            }
        }
        return list;
    }
}
