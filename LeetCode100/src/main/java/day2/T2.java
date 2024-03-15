package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T2 {
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int length = p.length();
        int start = 0;
        while (start+length<=s.length()){
            if (isEqual(s, start, length, p)){
                result.add(start);
            }
            start++;
        }
        return result;
    }

    private boolean isEqual(String s, int start, int length, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < length; i++) {
            ++sCount[s.charAt(start+i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        return Arrays.equals(sCount,pCount);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int sLength = s.length();

        if (pLength>sLength) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            ++pCount[p.charAt(i)-'a'];
            ++sCount[s.charAt(i)-'a'];
        }
        if (Arrays.equals(sCount,pCount)){
            result.add(0);
        }

        for (int i = 1; i+pLength <= sLength; i++) {
            --sCount[s.charAt(i-1)-'a'];
            ++sCount[s.charAt(i-1+pLength)-'a'];
            if (Arrays.equals(sCount,pCount)){
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new T2().findAnagrams("abab","ab"));
    }
}
