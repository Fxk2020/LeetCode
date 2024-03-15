package day6;
/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */

import java.util.ArrayList;
import java.util.Arrays;

public class T1 {

    public int firstMissingPositive2(int[] nums) {

        Arrays.sort(nums);//n2的复杂度
        int count = 1;
        int repeat = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0&&nums[i]!=repeat){
                if (nums[i]!=count) return count;
                count++;
                repeat = nums[i];
            }
        }
        return count;
    }

    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i]<=0){
                nums[i] = N+1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (Math.abs(nums[i])>=1&&Math.abs(nums[i])<=N){
                if (nums[Math.abs(nums[i])-1]>0){
                    nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return N+1;
    }

}
