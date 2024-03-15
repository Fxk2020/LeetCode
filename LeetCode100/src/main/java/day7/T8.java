package day7;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class T8 {

    public boolean isValidBST2(TreeNode root) {
        List<Integer> table = new ArrayList<>();
        inorder(root, table);
        for (int i = 0, j=1; i < table.size()-1; i++, j++) {
            if (table.get(j)<=table.get(i))return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> results) {
        if (root!=null){
            inorder(root.left, results);
            results.add(root.val);
            inorder(root.right,results);
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


}
