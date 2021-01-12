package algorithm.offer.Topic_0057_和为s的两个数字;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/11 : 10:52
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        return new int[0];
    }
}
