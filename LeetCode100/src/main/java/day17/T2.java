package day17;

public class T2 {

    public int uniquePaths(int m, int n) {

        if (m<2||n<2) return 1;

        int[][] dp = new int[m][n];
        dp[m-1][n-2] = 1;//左侧
        dp[m-2][n-1] = 1;//上方

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i==m-1&&j<n-2) dp[i][j] = dp[i][j+1];//只能右侧
                if (j==n-1&&i<m-2) dp[i][j] = dp[i+1][j];//只能下方
                if (i!=m-1&&j!=n-1) dp[i][j] = dp[i][j+1]+dp[i+1][j];//右侧+下方
            }
        }

        return dp[0][0];
    }

}
