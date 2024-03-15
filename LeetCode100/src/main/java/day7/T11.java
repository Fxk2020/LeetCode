package day7;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 */
public class T11 {

    public void flatten(TreeNode root) {

        if (root==null) return;
        List<TreeNode> table = new ArrayList<>();
        preOrder(root, table);

        TreeNode tmp = root;
        table.remove(0);
        while (!table.isEmpty()&&tmp!=null){
            tmp.right = table.get(0);
            table.remove(0);
            tmp.left = null;
            tmp = tmp.right;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> table) {
        table.add(root);
        if (root.left!=null) preOrder(root.left, table);
        if (root.right!=null) preOrder(root.right, table);
    }


}
