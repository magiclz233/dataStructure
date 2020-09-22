package algorithm.offer.Topic_0032_1_从上到下打印二叉树_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/22 : 9:23
 */
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
     public int[] levelOrder(TreeNode root){
        if(root == null) return new int[0];
         Queue<TreeNode> queue = new LinkedList(){{ add(root); }};
         ArrayList<Integer> list = new ArrayList<>();
         while (!queue.isEmpty()){
             TreeNode node = queue.poll();
             list.add(node.val);
             //queue先进先出  最先进去的是root  然后是root的左右孩子  这样在queue里面 root.left第二个出来,root.right第三个出来
             if(node.left != null) queue.add(node.left);
             if(node.right != null) queue.add(node.right);
         }
         // 这里不用stream的原因是,用了stream Leetcode执行时间倒数
         // return list.stream().mapToInt(Integer::intValue).toArray();

         int[] arr = new int[list.size()];
         for (int i = 0; i < list.size(); i++) {
             arr[i] = list.get(i);
         }
         return arr;
     }
}

/*
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 */
