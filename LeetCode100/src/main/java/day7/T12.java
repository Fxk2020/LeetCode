package day7;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class T12 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preorder_right = preorder.length-1;
        int inorder_right = inorder.length-1;
        return myBuildTree(preorder,0, preorder_right, inorder, 0, inorder_right);
    }

    private TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        if (preorderLeft>preorderRight) return null;
        if (preorderLeft==preorderRight) return new TreeNode(preorder[preorderLeft]);

        //寻找根节点在中序遍历中的位置
        int k = inorderLeft;
        while (inorder[k]!=preorder[preorderLeft]) k++;

        //递归
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        root.left = myBuildTree(preorder,preorderLeft+1,preorderLeft+k-inorderLeft,inorder,inorderLeft,k-1);
        root.right = myBuildTree(preorder, preorderLeft+k-inorderLeft+1, preorderRight, inorder, k+1, inorderRight);
        return root;

    }


}
