package day2;

import java.util.HashMap;

public class T1 {
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLength = 0, tmp=0;
        while(start<chars.length){
            for (int i = start; i < chars.length; i++) {
                if (table.containsKey(chars[i])){
                    maxLength = Math.max(tmp, maxLength);
                    start++;
                    table.clear();
                    tmp=0;
                    break;
                }else {
                    tmp++;
                    table.put(chars[i], 0);
                }
            }
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring(String s){
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0; //最左侧元素的index
        for (int i = 0; i < s.length(); i++) {
            if (table.containsKey(s.charAt(i))){
                left = Math.max(table.get(s.charAt(i))+1, left);
            }
            table.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new T1().lengthOfLongestSubstring("pwwkew"));
    }

}
