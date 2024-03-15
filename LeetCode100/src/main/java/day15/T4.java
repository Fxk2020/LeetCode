package day15;

import java.util.Arrays;

public class T4 {

    public boolean canPartition2(int[] nums) {

        int n = nums.length;

        if (n==1) return false;

        Arrays.sort(nums);
        int sum = 0;
        for (int num:
             nums) {
            sum+=num;
        }
        if (sum%2!=0) return false;
        int maxNum = nums[n-1];
        int target = sum/2;
        if (maxNum>target) return false;
        if (maxNum==target) return true;

        boolean[][] dp = new boolean[n][target+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < target+1; j++) {
                if (nums[i]<=j) dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n-1][target];

    }


    public boolean canPartition(int[] nums) {

        int n = nums.length;

        if (n==1) return false;

        int maxNum = 0;
        int sum = 0;
        for (int num:
                nums) {
            sum+=num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum%2!=0) return false;

        int target = sum/2;
        if (maxNum>target) return false;
        if (maxNum==target) return true;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j-nums[i]];
            }
        }
        return dp[target];

    }

}
