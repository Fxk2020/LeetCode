package day22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T1 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        if (n<1) return res;

        boolean[][] dp = new boolean[n][n];

        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {

                if (s.charAt(right)==s.charAt(left)
                        &&(right-left<=2||dp[left+1][right-1])) dp[left][right] = true;
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, n, stack, res, dp);
        return res;
    }

    private void dfs(String charArray, int start, int n, Deque<String> path, List<List<String>> res, boolean[][] dp) {

        if (start==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {

            if (dp[start][i]){
                path.addLast(charArray.substring(start, i+1));
                dfs(charArray, i+1, n, path, res, dp);
                path.removeLast();
            }
        }
    }


}
