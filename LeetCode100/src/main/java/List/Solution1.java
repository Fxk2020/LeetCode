package List;

public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNode = leftNode;

        for (int i = 0; i < right-left; i++) {
            rightNode = rightNode.next;
        }
        pre.next = null;
        ListNode suc = rightNode.next;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = suc;
        return dummyNode.next;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
