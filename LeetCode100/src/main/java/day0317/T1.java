package day0317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个正整数数组 nums 。
 *
 * 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。
 * 你可以执行以下操作 任意 次：
 *
 * 将数组里一个元素 增大 或者 减小 1 。
 * 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。
 */

public class T1 {

    public List<Long> minOperations(int[] nums, int[] queries) {

        int n = nums.length;

        Arrays.sort(nums);
        List<Long> res = new ArrayList<>();
        long[] pres = new long[n+1];
        for (int i = 0; i < nums.length; i++) {
            pres[i+1] = pres[i]+nums[i];
        }

        for (int q : queries) {
            int right = getRight(nums, q);
            long rightSum = (pres[n] - pres[right]) - (long) (n - right) * q;
            long leftSum = (long) right * q - pres[right];
            res.add(rightSum + leftSum);
        }
        return res;
    }

    private int getRight(int[] nums, int target) {
        //开区间（left,right）
        int left = -1;
        int right = nums.length;

        while (left+1<right){
            //至少有一个元素
            int mid = left+(right-left)/2;
            if (nums[mid]<target) left = mid;//开区间
            else right = mid;
        }

        return right;//索引
    }

}
