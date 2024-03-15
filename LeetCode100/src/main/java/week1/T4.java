package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class T4 {

    public int getIntIndex(int[] nums, int key) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int[] result = new int[2];

        int i=0,j=tmp.length-1;
        while (i<j){
            int sum = tmp[i]+tmp[j];
            if(sum<target){
                i++;
            }else if (sum>target){
                j--;
            }else {
                result[0] = getIntIndex(nums, tmp[i]);
                nums[result[0]] = Integer.MAX_VALUE;
                result[1] = getIntIndex(nums, tmp[j]);
                return result;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        /**
         * 用hashmap去做
         */
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (table.containsKey(target-nums[i])){
                return new int[]{i, table.get(target-nums[i])};
            }
            table.put(nums[i],i);
        }

        return new int[0];

    }


    public static void main(String[] args) {
        System.out.println(new T4().twoSum(new int[]{3,2,4}, 6));
    }

}
