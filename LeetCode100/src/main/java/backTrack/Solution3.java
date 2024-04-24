package backTrack;

import java.util.*;

public class Solution3 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(path, 0, candidates, target, res);

        return res;
    }

    private void backtrack(Deque<Integer> path, int start, int[] candidates, int target, List<List<Integer>> res) {

        if (target==0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i]>target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;//很关键在同一层时相同的元素不能重复计算
            path.addLast(candidates[i]);
            backtrack(path, i+1, candidates, target-candidates[i], res);
            path.removeLast();
        }

    }
}
