package algorithm.offer.Topic_0004_二维数组中的查找;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/4/4 23:36
 */
public class Me {

    /*
        二维数组中查找是否存在某个数字
     */

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        int num = 20;
        System.out.println(searchNum(arr,num));
    }


    public static boolean searchNum(int[][] arr, int num){

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
