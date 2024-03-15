package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class T3 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length-2; k++) {

            if (k>0&&nums[k]==nums[k-1]){
                continue;
            }
            if (nums[k]>0){
                break;
            }

            int i = k+1;
            int j = nums.length-1;
            while(i<j){
                int sum = nums[k]+nums[i]+nums[j];
                if (sum<0){
                    //跳过相同元素
                    while(i<j&&nums[i]==nums[++i]);
                }else if (sum>0){
                    //跳过相同元素
                    while(i<j&&nums[j]==nums[--j]);
                }else if (sum==0){
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //防止重复
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }

        }
        return res;

    }


    public static void main(String[] args) {
        new T3().threeSum(new int[]{1,-1,-1,0});
    }

}
