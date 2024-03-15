package day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class T3 {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> table = new HashMap<>();
        int[] topK = new int[k];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (table.containsKey(nums[i])){
                table.put(nums[i],table.get(nums[i])+1);
            }else {
                table.put(nums[i], 1);
            }
        }


        List<Integer>[] trunk = new List[length+1];
        for (Integer key:
                table.keySet()) {

            int num = table.get(key);
            if (trunk[num]==null){
                trunk[num] = new ArrayList<>();
            }
            trunk[num].add(key);
        }

        int index = 0;
        for (int i = length; i >=1 ; i--) {
            if (trunk[i]==null) continue;
            while (!trunk[i].isEmpty()){
                topK[index++] = trunk[i].get(0);
                trunk[i].remove(0);
            }
            if (index==k) break;
        }

        return topK;

    }


    public static void main(String[] args) {
        new T3().topKFrequent(new int[]{1,2}, 2);
    }


}
