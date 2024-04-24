package backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(n, k, 1, res, path);
        return res;
    }

    private void backtrack(int n, int k, int start, List<List<Integer>> res, Deque<Integer> path) {

        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrack(n, k, i+1, res, path);
            path.removeLast();
        }
    }
}
