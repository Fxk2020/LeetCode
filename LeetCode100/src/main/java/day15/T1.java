package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 */
public class T1 {

    List<Boolean> res = new ArrayList<>();
    public boolean wordBreak2(String s, List<String> wordDict) {

        removeAndFind(s, 0, wordDict);
        return !res.isEmpty();
    }

    private void removeAndFind(String target, int start, List<String> wordDict) {

        if (target.replace(" ", "").isEmpty()) res.add(true);

        for (int i = start; i < wordDict.size(); i++) {
            if (target.contains(wordDict.get(i))){
                removeAndFind(target.replace(wordDict.get(i), " "), start+1, wordDict);
            }
        }

    }


    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j]&&wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        new T1().wordBreak("ccaccc", new ArrayList<>(Arrays.asList("cc", "ac")));
    }

}
