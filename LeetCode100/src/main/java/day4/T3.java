package day4;

import java.util.ArrayList;

/**
 * 给你一个单链表的头节点 head ，
 * 请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class T3 {

    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> table = new ArrayList<>();
        while (head!=null){
            table.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < table.size()/2; i++) {
            if (table.get(i)!=table.get(table.size()-1-i)){
                return false;
            }
        }
        return true;
    }

}
