package day4;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class T4 {
    public boolean hasCycle2(ListNode head) {

        while (head!=null){
            if (head.val==Integer.MAX_VALUE){
                return true;
            }else {
                head.val = Integer.MAX_VALUE;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {

        Set<ListNode> table = new HashSet<>();

        while (head!=null){
            if (!table.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;

    }
}
