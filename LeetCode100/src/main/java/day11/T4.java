package day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class T4 {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        //一共有2^n个子集
        for (int i = 0; i < 1<<n; i++) {
            tmp.clear();
            for (int j = 0; j < n; j++) {
                //判断第j个元素是否在第i个子集中
                if ((i&(1<<j))!=0){
                    tmp.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(tmp));
        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println(5&4);
    }

}
