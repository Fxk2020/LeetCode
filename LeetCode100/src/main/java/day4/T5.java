package day4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。
 * 如果链表无环，则返回 null。
 */
public class T5 {
    public ListNode detectCycle2(ListNode head) {

        Set<ListNode> table = new HashSet<>();

        while (head!=null){
            if (!table.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        int time = 0;

        while(fast!=null){
            low = low.next;
            if (time==0){
                fast = fast.next;
                if(fast==null) return null;
            }
            fast = fast.next;
            if (fast==null) return null;

            if (fast==low&&time==0){
                fast = head;
                time++;
            }

            if (fast==low&&time==1){
                return fast;
            }
        }

        return null;

    }
}
