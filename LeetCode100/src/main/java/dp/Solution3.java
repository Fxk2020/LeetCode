package dp;

public class Solution3 {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];//得到金额j的方案数
        dp[0] = 1;//所有硬币都不选才能是0
        for (int coin:
             coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
