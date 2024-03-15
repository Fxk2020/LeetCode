package day7;

public class T2 {

    public int maxDepth(TreeNode root) {
        int deep = 0;
        if (root==null) return deep;
        if (root.left==null&&root.right==null) return ++deep;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;

    }

}
