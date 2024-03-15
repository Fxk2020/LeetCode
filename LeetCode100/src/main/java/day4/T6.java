package day4;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class T6 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        ListNode newHead;
        if (head1.val>head2.val){
            newHead = new ListNode(head2.val, null);
            head2 = head2.next;
        }else {
            newHead = new ListNode(head1.val, null);
            head1 = head1.next;
        }
        ListNode prev = newHead;

        while (head1!=null||head2!=null){
            if (head1==null){
                prev.next = head2;
                return newHead;
            }

            if (head2==null){
                prev.next = head1;
                return newHead;
            }


            if (head1.val>head2.val){
                prev.next = head2;
                head2 = head2.next;
            }else {
                prev.next = head1;
                head1 = head1.next;
            }

            prev = prev.next;
        }

        return newHead;
    }
}
