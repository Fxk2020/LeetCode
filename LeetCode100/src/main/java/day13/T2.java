package day13;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 */
public class T2 {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> pres = new HashMap<>();
        pres.put(0,1);
        int sum = 0;
        int res = 0;

        for (int num : nums) {
            sum += num;

            if (pres.containsKey(sum - k)) res += pres.get(sum - k);

            if (pres.containsKey(sum)) {
                pres.put(sum, pres.get(sum) + 1);
            } else pres.put(sum, 1);
        }

        return res;
    }


}
