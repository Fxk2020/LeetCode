package day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class T10 {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> inOrder = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> sheet = new ArrayList<>();
        if (root==null) return res;

        inOrder.add(root);
        while (!inOrder.isEmpty()){
            int size = inOrder.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = inOrder.poll();
                if (tmpNode.left!=null){
                    inOrder.add(tmpNode.left);
                }
                if (tmpNode.right!=null){
                    inOrder.add(tmpNode.right);
                }
                tmp.add(tmpNode.val);
            }
            sheet.add(tmp);
        }

        for (int i = 0; i < sheet.size(); i++) {
            int right = sheet.get(i).size();
            res.add(sheet.get(i).get(right-1));
        }

        return res;
    }


}
