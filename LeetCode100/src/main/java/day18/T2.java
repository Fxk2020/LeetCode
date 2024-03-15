package day18;

public class T2 {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;//只能进行删除操作，有几个字符删除几次
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;//只能进行插入操作，有几个字符插入几次
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char s1 = word1.charAt(i-1);
                char s2 = word2.charAt(j-1);

                if (s1==s2) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = minMy(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1;//替换、删除、插入操作

            }
        }
        return dp[n][m];
    }

    private int minMy(int i, int i1, int i2) {

        int tmp = i;
        if (tmp>i1) tmp=i1;
        if (tmp>i2) tmp=i2;
        return tmp;
    }

}
