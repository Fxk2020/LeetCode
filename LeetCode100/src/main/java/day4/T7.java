package day4;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class T7 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tmp = head;
        int length = 0;
        while (tmp!=null){
            length++;
            tmp = tmp.next;
        }
        if (length==1) return null;
        if (n==length) return head.next;

        ListNode tmp2 = head;
        for (int i = 0; i < length-n-1; i++) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp2.next.next;
        return head;
    }
}
