package algorithm.sort.插入排序;

import thread.chapter4.JDBCPool;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 16:00
 */
public class Main {

    /*
        插入排序:
        设定第一个数组第一个数据为已排序,其他的已排序进行比较,找到自己的位置,循环后面的未排序全部变成已排序
     */

    public static void main(String[] args) {
        sort(new int[]{6,3,11,23,4,5,6,2,2,13,1});
    }

    public static void sort(int[] arr){
        int n = arr.length;
        if(n <= 1) return;
        for (int i = 1; i < n; i++) {
            //设置第一次插入的数字为数组第二个数字
            int value = arr[i]; //3
            int j = i-1; //0
            for (; j >= 0 ; j--) {
                if(arr[j] > value){ //6 > 3
                    arr[j+1] = arr[j]; //arr[1]= 6
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
}
