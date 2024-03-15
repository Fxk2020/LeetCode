package week2;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * -----注意深拷贝的问题，指针指向一个地址
 */
public class T1 {

    public boolean isSame(String a, String b){

        Map<Character, Integer> table = new HashMap<Character, Integer>();
        char[] a_c = a.toCharArray();
        for (char i:
             a_c) {
            if (table.containsKey(i)){
                table.put(i, table.get(i)+1);
            }else {
                table.put(i, 1);
            }
        }
        char[] b_c = b.toCharArray();
        for (char j:
                b_c) {
            if (table.containsKey(j)){
                if (table.get(j)-1==0){
                    table.remove(j);
                }else {
                    table.put(j, table.get(j)-1);
                }
            }else {
                return false;
            }
        }
        if (table.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<String> tmp = new ArrayList<String>();
        List<List<String>> result = new ArrayList<List<String>>();

        ArrayList< String> arrayList = new ArrayList<String>(strs.length);
        Collections.addAll(arrayList, strs);

        while (!arrayList.isEmpty()){
            String a = arrayList.get(0);
            tmp.add(a);
            arrayList.remove(0);
            if (arrayList.isEmpty()){
                result.add(tmp);
                break;
            }
            for (String b:
                 arrayList) {
                if (isSame(a,b)){
                    tmp.add(b);
                }
            }
            for (String b:
                 tmp) {
                arrayList.remove(b);
            }
            List<String> tmp2 = new ArrayList<String>();
            tmp2.addAll(tmp);
            result.add(tmp2);
            tmp.clear();
        }
        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        System.out.println(new T1().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
