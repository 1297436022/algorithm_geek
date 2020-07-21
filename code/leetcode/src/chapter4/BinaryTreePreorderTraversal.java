package chapter4;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePreorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //前序遍历
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res) {
        //dfs 前序遍历
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
