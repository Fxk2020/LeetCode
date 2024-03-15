package day17;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class T3 {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (n==1&&m==1) return grid[0][0];

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);//上面和左面小的
            }
        }

        return dp[n-1][m-1];
    }

}
