package backTrack;

import java.util.*;

public class Solution5 {

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            Set<List<Integer>> ans = new HashSet<>();
            List<Integer> cur = new ArrayList<>();

            // 枚举 i 代表，枚举所有的选择方案状态
            // 例如 [1,2]，我们有 []、[1]、[2]、[1,2] 几种方案，分别对应了 00、10、01、11 几种状态
            for (int i = 0; i < (1 << n); i++) {
                cur.clear();
                // 对当前状态进行诸位检查，如果当前状态为 1 代表被选择，加入当前方案中
                for (int j = 0; j < n; j++) {
                    int t = (i >> j) & 1;
                    if (t == 1) cur.add(nums[j]);
                }
                // 将当前方案中加入结果集
                ans.add(new ArrayList<>(cur));
            }
            return new ArrayList<>(ans);
        }
    }




//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Set<List<Integer>> res = new HashSet<>();
//        Arrays.sort(nums);
//        backtrack(0,new ArrayList<>(), res, nums);
//        return new ArrayList<>(res);
//    }
//
//    private void backtrack(int start, ArrayList<Integer> path,Set<List<Integer>> res, int[] nums) {
//        res.add(new ArrayList<>(path));
//
//        for (int i = start; i < nums.length; i++) {
//            path.add(nums[i]);
//            backtrack(i+1, path, res, nums);
//            path.remove(path.size()-1);
//        }
//    }

    }
