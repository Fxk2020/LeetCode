package day4;

import java.util.ArrayList;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class T11 {

    /**
     * 将两个升序链表合并升序返回
     * @param list1
     * @param list2
     * @return
     */
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

    /**
     * 对k个链表进行两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        if (lists.length==0){
            return null;
        }

        ListNode ans = null;

        int k = lists.length;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {

        if (l==r) return lists[l];
        if (l>r) return null;

        int mid = (l+r)/2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
    }

}
