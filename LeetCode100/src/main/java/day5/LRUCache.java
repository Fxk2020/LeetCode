package day5;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Integer> table;
    int capacity = 0;//记录容量
    int count = 0;//记录使用了多少
//    记录最近最少使用
    ArrayList<Integer> lru;
    public LRUCache(int capacity) {
        this.table = new HashMap<>();
        this.capacity = capacity;
        lru = new ArrayList<>();
    }

    public int get(int key) {
        if (lru.contains(key)){
            lru.remove(lru.indexOf(key));
            lru.add(key);
        }
        if (table.containsKey(key)) return table.get(key);
        else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (count==capacity){
            if (table.containsKey(key)){
                table.put(key,value);
                lru.remove(lru.indexOf(key));
                lru.add(key);
            }else {
                //需要删除数据
                table.remove(lru.get(0));
                lru.remove(0);
                table.put(key, value);
                lru.add(key);
            }
        }else {
            if (table.containsKey(key)){
                table.put(key, value);
                lru.remove(lru.indexOf(key));
                lru.add(key);
            }else {
                count++;
                table.put(key, value);
                lru.add(key);
            }
        }
    }
}
