package algorithm.offer.Topic_0033_二叉搜索树的后序遍历序列;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/25 : 16:29
 */
public class Main {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length-1);
    }

    boolean helper(int[] pos, int left,int right){
        // 只有一个节点或者为null 直接返回
        if(left >= right){
            return true;
        }
        //因为数组中最后一个值pos[right]是根节点，这里从左往右找出第一个比
        //根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，
        //因为最后一个是根节点），他前面的都是根节点的左子节点
        int mid = left;
        int root = pos[right];
        while (pos[mid] < root){
            mid++;
        }
        int temp = mid;
        //因为pos[mid]前面的值都是比根节点root小的，
        //我们还需要确定pos[mid]后面的值都要比根节点root大，
        //如果后面有比根节点小的直接返回false
        while (temp < right){
            if(pos[temp++] < root){
                return false;
            }
        }
        //然后对左右子节点进行递归调用
        return helper(pos,left,mid-1) && helper(pos,mid,right-1);
    }
}

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 */