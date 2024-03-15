package day15;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class T2 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        if (n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        int max = 0;

        for (int i = 2; i <= n ; i++) {
            int tmp = 1;
            for (int j = 0; j < i-1; j++) {
                if (nums[i-1]>nums[j]){
                    tmp = Math.max(tmp, dp[j+1]+1);
                }
            }
            dp[i] = tmp;
            if (tmp>max) max = tmp;
        }

        return max;
    }


}
