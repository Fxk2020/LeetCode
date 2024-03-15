package day7;

import java.util.ArrayList;

/**
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class T13 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs1(root);
        return res;

    }

    private void dfs1(TreeNode root) {

        if (root==null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    private void dfs2(TreeNode root, int val) {

        if (val>res) res = val;
        if (root.left!=null) dfs2(root.left, val+root.left.val);
        if (root.right!=null) dfs2(root.right, val+root.right.val);

    }


}
