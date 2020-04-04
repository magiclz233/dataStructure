package algorithm.offer.Topic_0003_数组中重复的数字;


import java.util.HashSet;
import java.util.Set;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/4/4 23:24
 */
public class Main {

    /*
        找出数组中重复的数字。

        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
        但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,2,3,4,1};
        System.out.println(searchNum(arr));
    }

    /*
        思路:
        让返回任意一个重复的数字,那么可以把数组保存进Set,因为Set是不可重复的,
        如果保存失败,那么这个数字就是重复的,直接返回即可.
     */

    public static int searchNum(int[] arr){
        Set<Integer> set = new HashSet<>();
        int num = -1;

        for (int i : arr) {
            if (!set.add(i)) {
                num = i;
                break;
            }
            }
        return num;
    }
}
