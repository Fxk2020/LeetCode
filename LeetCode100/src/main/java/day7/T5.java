package day7;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class T5 {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {

        if (root==null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R)+1;

    }

}
