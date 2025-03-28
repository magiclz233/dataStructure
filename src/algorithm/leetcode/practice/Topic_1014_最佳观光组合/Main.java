package algorithm.leetcode.practice.Topic_1014_最佳观光组合;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/6/17 : 15:01
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{8,1,5,2,6};
        System.out.println(maxScore(arr));
    }

    public static int maxScore(int[] A) {
        int a = 0;
        int m = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            a = Math.max(a, m + A[j] - j);
            m = Math.max(m,A[j]+j);
        }
        return a;
    }
}
