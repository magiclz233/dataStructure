package algorithm.leetcode.Topic_0547_省份数量;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Dfs
 * @date 2021/1/7 : 14:15
 */
public class Dfs {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    /*
        [ 1  0  0
          0  1  0
          0  0  1 ]
     */

    // dfs
    public static int findCircleNum(int[][] isConnected) {

        // 获取总共有多少个节点
        int n = isConnected.length;
        // 定义一下数组标识的节点是否已经被访问
        boolean[] vis = new boolean[n];
        int cut = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cut++;
                dfs(i, isConnected, vis);
            }
        }
        return cut;
    }

    public static void dfs(int i, int[][] isConnected, boolean[] vis) {
        // 已经访问了i位置的节点
        vis[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                dfs(j, isConnected, vis);
            }
        }
    }
}
