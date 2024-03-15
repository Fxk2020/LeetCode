package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorder(root, results);
        return results;
    }

    private void inorder(TreeNode root, List<Integer> results) {
        if (root!=null){
            inorder(root.left, results);
            results.add(root.val);
            inorder(root.right,results);
        }
    }


}
