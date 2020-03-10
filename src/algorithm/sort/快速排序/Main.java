package algorithm.sort.快速排序;

import java.util.Arrays;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/10 17:30
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{6,3,11,23,4,5,6,2,2,13,1};

        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left,int right){
       if(left > right) return;
        //定义变量 保存基准数
        int base = arr[left];
        //定义变量i,j  指向最左边/最右边
        int i = left;
        int j = right;

        //当i,j不相遇  一直检索
        //先让j从右往走 检索到比基准数小的就停下,大等于一直走
        //再让i从左边走  检索到比基准数大的就停下,小于或等于一直走
        while (j-i > 1){
            while (arr[j] >= base && i < j){
                j--;
            }
            while (arr[i] <= base && i < j){
                i++;
            }

            //i,j已经找到,交换i,j位置元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //如果上面的while不成立
        //i = j 相遇了 交换基准数和相遇位置的元素
        //先把相遇位置的元素赋值给基准数位置的元素
        arr[left] = arr[i];
        //把基准数复制给相遇位置的元素
        arr[i] = base;

        //基准数归位了 左边都比基准数小,右边都比基准数大

        //继续排序基准数左右的顺序
        //排基准数的左边
        sort(arr,left,i-1);
        //排基准数右边
        sort(arr,j+1,right);

    }
}
