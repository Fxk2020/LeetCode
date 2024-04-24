package lru;

import java.util.HashMap;

public class LRUCache {

    class LinkedNode{

        LinkedNode pre;
        LinkedNode next;
        int key;
        int value;

        LinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
        LinkedNode(){}

        public int getValue(){
            return this.value;
        }
        public void setValue(int value){
            this.value = value;
        }

    }

    int capacity;
    int size;
    private LinkedNode head, tail;
    HashMap<Integer, LinkedNode> caching;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.caching = new HashMap<Integer, LinkedNode>();

        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;

    }

    public void put(int key, int value){
        if (caching.containsKey(key)){
            LinkedNode newNode = caching.get(key);
            newNode.setValue(value);
            removeNode(newNode);
            addHeadNode(newNode);
        }else {
            LinkedNode tmp = new LinkedNode(key, value);
            if (size==capacity){
                caching.remove(tail.pre.key);
                removeTail();
                size--;
            }
            addHeadNode(tmp);
            caching.put(key, tmp);
            size++;
        }
    }

    private void addHeadNode(LinkedNode newNode) {
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
        newNode.pre = head;
    }

    private void removeNode(LinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void removeTail(){
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }

    public int get(int key){
        if (caching.containsKey(key)){
            LinkedNode node = caching.get(key);
            removeNode(node);
            addHeadNode(node);
            return node.value;
        }else {
            return -1;
        }
    }

}
