package day21;

import java.util.*;

public class T5 {

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();

        if (n==0) return res;

        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, n, stack, res);
        return res;
    }

    private void dfs(char[] charArray, int start, int n, Deque<String> path, List<List<String>> res) {

        if (start==n){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <n; i++) {
            if (!checkPalindrome(charArray, start, i)){
                continue;//剪枝操作
            }

            //1.尝试
            path.addLast(new String(charArray, start, i-start+1));
            //2.进一步尝试
            dfs(charArray, i+1, n, path, res);
            //3.回退
            path.removeLast();
        }


    }

    private boolean checkPalindrome(char[] charArray, int left, int right) {

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

}
