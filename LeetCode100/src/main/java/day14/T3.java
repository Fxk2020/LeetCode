package day14;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class T3 {

    public int rob(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        if (n==0) return 0;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);

        res[0] = nums[0];
        boolean flag = false;
        if (nums[1]>nums[0]){
            res[1] = nums[1];
            flag = true;
        }else {
            res[1] = nums[0];
        }

        for (int i = 2; i < n; i++) {
            if (flag){

                if (res[i-1]>res[i-2]+nums[i]){
                    flag = false;
                    res[i] = res[i-1];
                }else {
                    flag = true;
                    res[i] = res[i-2]+nums[i];
                }


            }else {
                res[i] = res[i-1]+nums[i];
                flag = true;
            }
        }

        return res[n-1];
    }

}
