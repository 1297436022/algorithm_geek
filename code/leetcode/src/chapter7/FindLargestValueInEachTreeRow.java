package chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FindLargestValueInEachTreeRow {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues2(TreeNode root) {
        //DFS
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size() + 1) {
            res.add(root.val);
        } else {
            res.set(level - 1, Math.max(res.get(level - 1), root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }


    public List<Integer> largestValues1(TreeNode root) {
        //BFS
        //LinkedList实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll(); //出队
                max = Math.max(max, node.val); //记录每层的最大值
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            values.add(max);
        }
        return values;
    }



    public static void main(String[] args) {

    }
}
