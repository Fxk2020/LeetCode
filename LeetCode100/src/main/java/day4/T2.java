package day4;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

 class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class T2 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;//记录前一个节点
        ListNode cur = head;
        if (cur==null){
            return null;
        }
        ListNode next = head.next;

        while (next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }


}
