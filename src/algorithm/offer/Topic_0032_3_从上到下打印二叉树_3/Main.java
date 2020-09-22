package algorithm.offer.Topic_0032_3_从上到下打印二叉树_3;

import java.util.*;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/22 : 10:34
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> nums = new ArrayList<>();
        if (root != null) queue.add(root);
        // root已经直接给了,nums.add(tmp) 从第一层root开始  当为偶数层时 反转tmp然后add到nums
        int high = 1;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (high++ % 2 == 0) Collections.reverse(tmp);
            nums.add(tmp);
        }
        return nums;
    }
}

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */