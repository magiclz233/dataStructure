package algorithm.sort.冒泡排序;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 15:48
 */
public class Main {
    public static void main(String[] args) {
        sort(new int[]{6,3,11,23,4,5,6,2,2,13,1});
    }
    public static void sort(int[] arr){
        if(arr.length <=1) return;
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            //提前退出循环的标记
            boolean flag = false;
            for (int j = 0; j < n-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
