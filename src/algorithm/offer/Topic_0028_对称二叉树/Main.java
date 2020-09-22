package algorithm.offer.Topic_0028_对称二叉树;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/21 : 16:32
 */
public class Main {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left,root.right);
    }

    public boolean recur(TreeNode left,TreeNode right){
        if(left ==null && right == null) return true;
        if(left == null ||right == null || left.val != right.val) return false;
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
}

/*
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 */