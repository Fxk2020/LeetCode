package day4;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */

import java.util.HashMap;
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class T1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashMap<ListNode, Integer> table = new HashMap<>();

        ListNode pA = headA;
        while (pA!=null){
            table.put(pA, 1);
            pA = pA.next;
        }

        ListNode pB = headB;
        while (pB!=null){
            if (table.containsKey(pB)){
                return pB;
            }
            pB = pB.next;
        }

        return null;
    }

}
