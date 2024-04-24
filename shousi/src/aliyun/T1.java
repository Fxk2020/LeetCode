package aliyun;
import java.util.*;

public class T1 {

    public static Set<String> getStrs(String[] str1, String[] str2){
        HashMap<String, Integer> res1 = new HashMap<>();
        for (String str:
             str1) {
            res1.put(str, 1);
        }

        Set<String> result = new HashSet<>();
        for (String str:
             str2) {
            if (res1.containsKey(str)) result.add(str);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] st1 = new String[]{"a","a","b","a","a","b","fas","a"};
        String[] st2 = new String[]{"dafasfd","a","b","a","dafasadfafd","dfa","fas","asdf"};
        Set<String> strs = getStrs(st1, st2);
        for (String str:
             strs) {
            System.out.println(str);
        }
    }
}
