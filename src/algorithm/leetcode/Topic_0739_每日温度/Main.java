package algorithm.leetcode.Topic_0739_每日温度;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/6/11 : 9:18
 */
public class Main {

    /*
    根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

    例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

    提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */

    public static void main(String[] args) {
        int[] arr = new int[]{70,71,73,68,79,77,80};
        int[] daily = daily(arr);
        System.out.println(Arrays.toString(daily));
    }

    public static int[] daily(int[] T){
        if(T == null || T.length == 0) return new int[0];
        int[] arr = new int[T.length];
        for (int i = 0; i < T.length-1; i++) {
            if(T[i] <= 100){
                for (int j = i+1; j < T.length; j++) {
                    if(T[j] > T[i]){
                        arr[i] = j-i;
                        break;
                    }
                }
            }

        }
        return arr;
    }
}
