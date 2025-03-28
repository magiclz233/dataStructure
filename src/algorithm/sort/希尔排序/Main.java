package algorithm.sort.希尔排序;

import java.util.Arrays;

/**
 * 希尔排序是插入排序的改良版本
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 22:50
 */
public class Main {

    /*
        希尔排序
        将排序的数组等分， g = length/2
        分为g组 arr[0],arr[g] 一组 arr[1],arr[g+1]一组  全部分好组，组内进行判断 前面的大于后面的，互换位置
        然后再 g1 = g/2
        分为g1组 然后对组内进行排序
        再继续分为g2 = g1/2
        组内直接插入排序
        直到 g(n) = 1 排序完成
        再将最后的数组进行直接插入排序
     */

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换法 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        //定义增量g进行循环，并逐渐缩小增量
        for (int g = arr.length/2;g> 0; g /= 2){
            //从第g个元素开始，逐个进行直接插入排序操作
            for (int i=g;i<arr.length;i++){
                int j = i;
                while (j-g >=0 && arr[j] < arr[j-g]){
                    swap(arr,j,j-g);
                    j -= g;
                }
            }
        }
    }

    /**
     * 希尔排序 移动法  针对有序序列在插入时使用
     * @param arr
     */
    public static void sort(int[] arr){
        for(int g = arr.length/2;g>0;g /= 2){
            for (int i = g;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-g]){
                    //当j-g大于0 互换
                    while(j-g>= 0 && temp < arr[j-g]){
                        arr[j] = arr[j-g];
                        //互换完了之后  重置j = j-g 也就是组中前面的位置
                        j -= g;
                    }
                    // 因为上面的j 已经重新赋值成前面的位置,所以,相当于已经互换
                    arr[j] = temp;
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
