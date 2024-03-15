package day4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 */
public class T9 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode tmp = start;

        ListNode[] table = new ListNode[k];
        ListNode test = head;
        int i = 0;
        while (test!=null){
            table[i] = test;
            test = test.next;
            i++;
            if (i==k){
                //进行翻转
                tmp.next = table[k-1];
                table[0].next = tmp.next.next;
                for (int j = 1; j < k; j++) {
                    table[j].next = table[j-1];
                }
                tmp = table[0];
                i=0;
            }
        }
        return start.next;
    }

}
