package algorithm.sort;

import java.util.Arrays;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname test1
 * @description TODO 冒泡排序
 * @date 2020/2/27 11:46
 */
public class test1 {

    public static void main(String[] args) {
        int[] arr = {1,23,4,1,32,3,1,1,3,2,3,5,6,1};
        int[] test = test(arr);
       System.out.println(Arrays.toString(test));
    }
    public static int[] test(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
