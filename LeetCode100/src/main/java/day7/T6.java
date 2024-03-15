package day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T6 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                tmp.add(front.val);
                if (front.left!=null){
                    queue.add(front.left);
                }
                if (front.right!=null){
                    queue.add(front.right);
                }
            }
            result.add(tmp);

        }
        return result;
    }


}
