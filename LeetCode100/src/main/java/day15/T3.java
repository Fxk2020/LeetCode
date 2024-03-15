package day15;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class T3 {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        if (n==1) return nums[0];
        int max = Integer.MIN_VALUE;
        int iMax = 1;
        //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。
        int iMin = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i]<0){
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }

            iMax = Math.max(iMax*nums[i], nums[i]);
            iMin = Math.min(iMin*nums[i], nums[i]);
            max = Math.max(max, iMax);

        }

        return max;

    }

    public int maxProduct2(int[] nums) {

        //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。

        int n = nums.length;
        if (n==1) return nums[0];
        int[] dp = new int[n+1];

        dp[1] = nums[0];
        boolean flag = true;

        for (int i = 2; i <= n ; i++) {

            if (flag){
                if (dp[i-1]*nums[i-1]>dp[i-1]){
                    dp[i] = dp[i-1]*nums[i-1];
                } else if (dp[i-1]*nums[i-1]==dp[i-1]){
                    if (dp[i-1]==0&&nums[i-1]>0){
                        dp[i] = nums[i-1];
                    }else {
                        dp[i] = dp[i-1];
                    }
                }else {
                    if (nums[i-1]>=dp[i-1]) dp[i] = nums[i-1];
                    else {
                        dp[i] = dp[i-1];
                        flag = false;
                    }
                }
            }else {
                if (nums[i-1]>=dp[i-1]){
                    dp[i] = nums[i-1];
                    flag = true;
                }else {
                    dp[i] = dp[i-1];
                }
            }

        }
        return dp[n];

    }

}
