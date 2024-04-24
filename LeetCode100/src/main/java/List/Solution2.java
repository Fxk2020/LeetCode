package List;

public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode tmp = head;
        int length = 1;
        while (tmp.next!=null){
            length++;
            tmp = tmp.next;
        }

        tmp.next = head;
        k = length-k%length;

        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode iNode = head;
        for (int i = 0; i < k; i++) {
            preNode = preNode.next;
            iNode = iNode.next;
        }

        preNode.next = null;
        return iNode;
    }
}
