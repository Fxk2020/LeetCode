package backTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,new ArrayList<>(), res, nums);
        return res;
        }

    private void backtrack(int start, ArrayList<Integer> path, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i+1, path, res, nums);
            path.remove(path.size()-1);
        }


    }
}
