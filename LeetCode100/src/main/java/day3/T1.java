package day3;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class T1 {
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1]<0?nums[i]:dp[i-1]+nums[i];
        }

        Arrays.sort(dp);

        return dp[dp.length-1];
    }

    public int maxSubArray(int[] nums) {
        int pre=0,maxAns=nums[0];
        for (int x:
             nums)  {
            pre = Math.max(pre+x,x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }


}
