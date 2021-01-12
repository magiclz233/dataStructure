package algorithm.offer.Topic_0047_礼物的最大价值;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/7 : 17:01
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
        System.out.println(maxValuePro(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static int maxValuePro(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
