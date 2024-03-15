package day7;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class T4 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isEqual(TreeNode p, TreeNode q){
        if (p == null && q == null) {
            return true;
        }else if (p == null||q == null) {
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isEqual(p.left,q.left) && isEqual(p.right,q.right);
        }
    }

    public boolean isSymmetric2(TreeNode root) {

        if (root==null) return true;
        root.left = invertTree(root.left);
        return isEqual(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {

        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }
        return left.val==right.val && check(left.left,right.right) && check(left.right, right.left);
    }

}
