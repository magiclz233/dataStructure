package algorithm.leetcode.Topic_0011_盛最多水的容器;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/6/17 : 15:12
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    /*
        双指针,定一个接受参数res, i,j 分别为头尾指针
        开始计算, 木桶应该计算的是 (j-i) 再乘以 数小的那个
        计算出结果后, 赋值给res
         相应的对小的那个 进行 ++ 或者 --操作
        再跟res比较 大的赋值给res
        最终的res就是最大容量的桶
     */

    public static int maxArea(int[] height){
        int i = 0,j = height.length-1,res = 0;
        while (i < j){
            res = height[i] < height[j] ?
                    Math.max(res,(j-i) * height[i++]) :
                    Math.max(res, (j-i) * height[j--]);
        }
        return res;
    }
}
