package day7;

import java.util.ArrayList;
import java.util.List;

public class T9 {

    int res, k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }



    private void inorder(TreeNode root) {
        if (root!=null){
            inorder(root.left);
            if (--k==0) res = root.val;
            inorder(root.right);
        }
    }

}
