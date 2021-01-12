package algorithm.leetcode.Topic_0189_旋转数组;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/8 : 9:27
 */
public class Main {
    public static void main(String[] args) {
       // rotate1(new int[]{1,2,3,4,5,6,7},3);
        rotate2(new int[]{1,2,3,4,5,6,7},3);
    }
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[(i+k)%length] = nums[i];
        }
        System.arraycopy(arr,0,nums,0,length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
