package day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集和问题
 */
public class T2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(state, candidates, target, 0, res);
        return res;
    }

    private void backtrack(List<Integer> state, int[] candidates, int target, int start, List<List<Integer>> res) {

        if (target==0){
            res.add(new ArrayList<>(state));
        }

        for (int i = start; i < candidates.length; i++) {

            if (target-candidates[i]<0) break;
            //尝试
            state.add(candidates[i]);
            //下一次选择
            backtrack(state, candidates, target-candidates[i], i, res);//可以重复
            //回退
            state.remove(state.size()-1);

        }
    }

}
