package chapter4;

import java.util.*;

class BinaryTreeInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        //bfs(root, res);
        return res;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        //迭代实现
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        //dfs 中序遍历
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    private void bfs(TreeNode root, List<Integer> res) {
        //bfs  层次遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
