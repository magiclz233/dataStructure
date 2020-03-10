package algorithm.sort.选择排序;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 16:23
 */
public class Main {
    /*public static void main(String[] args) {
        sort(new int[]{6,3,11,23,4,5,6,2,2,13,1});
    }

    public static void sort(int[] arr){

    }*/


    /*
        选择排序:
        类似于插入排序 分为已排区间,未排区间
        但是选择排序每次会在未排序区间找到最小的/最大的,来按照顺序放入已排序区间
     */

    public static void main(String[] args) {
        sort(new int[]{6,3,11,23,4,5,6,2,2,13,1});
    }

    public static void sort(int[] arr){
        int n = arr.length;
        if(n <= 1) return;

        for (int i = 0; i < n-1; i++) {
            int k = i;
            for (int j = k+1; j < n; j++) {
                if(arr[j] < arr[k]){
                    k = j;
                }
            }
            if(i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
