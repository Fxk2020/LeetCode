package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T10 {

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
     * 归并排序，从底至顶直接合并
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        int length = 0;
        ListNode tmp = head;
        while (tmp!=null){
            length++;
            tmp = tmp.next;
        }
        ListNode newHead = new ListNode(0, head);

//        <<左移运算符<<1 = *2  >>右移运算符>>1 = /2
        for (int subLength = 1; subLength < length; subLength<<=1) {
            ListNode pre = newHead;
            ListNode cur = pre.next;
            while (cur!=null){
                ListNode head1 = cur;
                for (int i = 1; i < subLength&&cur.next!=null; i++) {
                    cur = cur.next;
                }

                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength&&cur!=null&&cur.next!=null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur!=null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode mergeNodes = mergeTwoLists(head1, head2);
                pre.next = mergeNodes;
                while (pre.next!=null){
                    pre = pre.next;
                }
                cur = next;
            }

        }
        return newHead.next;
    }

    /**
     * 对val的值进行记录然后依次更改
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        int length = 0;

        ListNode tmp = head;
        while (tmp!=null){
            length++;
            tmp = tmp.next;
        }

        int[] vals = new int[length];
        tmp = head;
        length = 0;
        while (tmp!=null){
            vals[length++] = tmp.val;
            tmp = tmp.next;
        }

        Arrays.sort(vals);

        tmp = head;
        length = 0;
        while (tmp!=null){
            tmp.val = vals[length++];
            tmp = tmp.next;
        }
        return head;
    }

}
