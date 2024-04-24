package dp;

import java.util.Arrays;

public class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2) return false;
        int maxNum = nums[0];
        int sum = 0;

        for (int num:
             nums) {
            sum+=num;
            if (num>maxNum) maxNum = num;
        }

        if (sum%2!=0) return false;//和是奇数肯定无法分成等和的两部分
        int targetNum = sum/2;
        if (maxNum>targetNum) return false;//最大值大于和的一半肯定无法分成等和的两部分

        boolean[][] dp = new boolean[n][targetNum+1];//在(0,n-1)范围内选择元素能否恰好和是j；

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= targetNum; j++) {
                int cur = nums[i];
                if (cur<=j) dp[i][j] = dp[i-1][j]||dp[i-1][j-cur];
                else dp[i][j] = dp[i-1][j];
            }
            if (dp[i][targetNum]) return true;//进行剪枝
        }

        return dp[n-1][targetNum];
    }
}
