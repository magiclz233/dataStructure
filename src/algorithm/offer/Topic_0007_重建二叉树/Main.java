package algorithm.offer.Topic_0007_重建二叉树;

/**
 * TODO 根据给出的二叉树前序遍历和中序遍历结果 得到二叉树结构
 * @author magic_lz
 * @version 1.0
 * @date 2020/4/5 18:43
 */
public class Main {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }

    /*
        还原之前,先了解二叉树前序遍历,中序遍历
        前序遍历: 根-左-右
        中序遍历: 左-根-右

        前序遍历的第一个节点a 就是根节点  然后再判断中序遍历 在a左边的 都是左子树  右边的为右子树

     */

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return null;
    }
}
