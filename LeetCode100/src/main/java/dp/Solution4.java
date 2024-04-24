package dp;

public class Solution4 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j==i+1) {
                        dp[i][j] = true;
                        res++;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]) res++;
                    }
                }
            }
        }

        return res;
    }
}
