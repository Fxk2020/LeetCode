package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 */
public class T3 {

    public List<Integer> partitionLabels2(String s) {

        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        char[] strs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char letter = strs[i];
            if (!hashMap.containsKey(letter)){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                hashMap.put(letter, tmp);
            }else {
                hashMap.get(letter).add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char letter2 = strs[i];
            ArrayList<Integer> letterList = hashMap.get(letter2);
            int right = letterList.get(letterList.size()-1);
            right = Math.max(right, getMax2(s,i,right, hashMap, letter2));
            res.add(right-i+1);
            i = right;
        }
        return res;
    }

    private int getMax2(String s, int i, int right, HashMap<Character, ArrayList<Integer>> hashMap, char letter2) {
        int maxValue = right;
        for (int j = i+1; j < right; j++) {
            if (s.charAt(j)!=letter2){
                ArrayList<Integer> list = hashMap.get(s.charAt(j));
                int tmp = list.get(list.size()-1);
                if (tmp>maxValue) {
                    maxValue = tmp;
                    right = tmp;//right也要扩容
                }
            }
        }
        return maxValue;
    }

    public List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<>();
        int[] letters = new int[26];
        int length = s.length();
        char[] strs = s.toCharArray();

        for (int i = 0; i < length; i++) {
            letters[strs[i]-'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, letters[strs[i]-'a']);
            if (i==end){
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;

    }


}
