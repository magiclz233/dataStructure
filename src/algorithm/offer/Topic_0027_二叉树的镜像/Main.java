package algorithm.offer.Topic_0027_二叉树的镜像;

import java.util.Stack;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/21 : 16:21
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

    public TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}

/*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */