package stack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> counts = new HashMap<>();//记录每个key对应的出现次数
        for (int num:
             nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> res = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counts.get(o1)-counts.get(o2);
            }
        });//记录出现次数从小到大的key集合

        for (Integer key:counts.keySet()){
            if (res.size()<k) res.add(key);
            else {
                if (counts.get(res.peek())<counts.get(key)){
                    res.remove();
                    res.add(key);
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = res.poll();
        }
        return result;
    }

}
