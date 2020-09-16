package algorithm.offer.Topic_0021_调整数组顺序奇数在偶数前面;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/16 : 14:28
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(11 & 1);

    }

    public static int[] exchange(int[] nums){
        int i = 0,j = nums.length-1,tmp;
        while (i < j) {
            // 奇数
            while (i < j && (nums[i] & 1) == 1){
                i++;
            }
            // 偶数
            while (i < j && (nums[j] & 1) == 0){
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
