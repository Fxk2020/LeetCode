package week2;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class T2 {

    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> tmps = new ArrayList<Integer>();
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {

//            说明是连续的
            if (nums[i]==nums[i-1]+1){
                tmp++;
            }
//            有相同的元素
            else if (nums[i]==nums[i-1]){

            }
            else {
//                连续中断
                if (tmp>=2){
                    tmps.add(tmp);
                    tmp = 1;
                }
            }
        }
        tmps.add(tmp);
        return Collections.max(tmps);
    }


    public static void main(String[] args) {
        System.out.println(new T2().longestConsecutive(new int[]{1}));
    }

}
