package day21;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法--解决全排列问题
 */
public class T1 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backtrrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    private void backtrrack(ArrayList<Integer> state, int[] nums, boolean[] choices, List<List<Integer>> res) {

        if (state.size()==choices.length){
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            int tmp = nums[i];
            if (!choices[i]){
                //尝试
                choices[i] = true;
                state.add(tmp);
                //下一轮选择
                backtrrack(state, nums, choices, res);
                //回退
                state.remove(state.size()-1);
                choices[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        new T1().permute(new int[]{1,2,3});
    }


}
