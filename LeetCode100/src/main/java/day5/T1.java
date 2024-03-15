package day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
 * 该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点
 */
public class T1 {
    Map<Node, Node> table = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }

        if (!table.containsKey(head)){
            Node headNew = new Node(head.val);
            table.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }

        return table.get(head);//必须返回的是新创建的节点
    }

}
