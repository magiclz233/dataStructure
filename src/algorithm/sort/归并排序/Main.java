package algorithm.sort.归并排序;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 17:06
 */
public class Main {

    /*
        归并排序:
        如果一个数组有n个数据，则可以把这个数组看作n个有序的子序列，每个子序列的长度为1，
        然后两两归并，就能得到[n/2]个长度为2（或者1，落单的)的字序列，再不断地两两归并，
        直到得到一个长度为n的有序数组。
     */


    public static void main(String[] args) {
        int[] arr = {9, 24, 52, 11, 3, 23, 91, 5, 2, 1, 8};
        System.out.println(Arrays.toString(arr));
        //归并排序递归方法
//        mergeSort(arr, 0, arr.length - 1);
        //归并排序非递归方法
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 归并排序
     *
     * @param arr  数组
     * @param low  数组的第一个元素的下标
     * @param high 数组的最后一个元素的下标
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 1) return;

        //使用递归的方式进行归并排序  空间复杂度为O(N + logN)
        int mid = (low + high) / 2;
        if (low < high) {
            //递归的对左右两边进行排序
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }

    }

    /**
     * merge的功能是讲两个有序的数组合并成一个数组
     * 因为数组有序，合并很简单，只要维护几个指针就可以了
     *
     * @param arr  数组
     * @param low  左起点
     * @param mid  中间点
     * @param high 终点
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用来暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        for (; i <= mid && j <= high; k++) {
            //将左右两个数组进行从0位置的比较,
            //哪个小,先保存进temp,并且代表的指针前进一位,循环进行比较
            if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        //接下来两个while循环是为了将剩余的(比另一边多出来的个数) 放到temp中去
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            //递归函数的组成,不能直接用l  有可能传进来的只是arr的子模块进行排序
            arr[low + l] = temp[l];
        }
    }

    /**
     * 归并排序非递归方法
     * @param arr
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        int k = 1;
        while (k < len) {
            //将数组中相邻的两个部分的数字进行排序并归并  k=1,从两个开始
            mergePass(arr, k, len);
            System.out.println(Arrays.toString(arr));
            k *= 2;
        }
    }

    /**
     * 负责将数组中的相邻的k个元素的子序列进行归并
     *
     * @param arr
     * @param k
     * @param len
     */
    public static void mergePass(int[] arr, int k, int len) {

        int i = 0;
        int j;

        //从前往后,将2个长度为k的子序列合并为1个
        //将数组中相邻的两个部分的数字进行排序并归并  k=1,从两个开始 0,1位置 2,3位置,4,5位置....
        //第一遍全部排序后,第二遍k= 1*2,将0123,4567,...位置分别合并排序
        //继续合并 直到 最后k=arr.length   将最大的两个组合并排序
        while (i < len - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }
        //这段代码保证了,将那些落单的长度不足两两merge的部分和前面合并起来
        if (i < len - k) {
            merge(arr, i, i + k - 1, len - 1);
        }
    }
}

