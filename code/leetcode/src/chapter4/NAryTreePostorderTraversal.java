package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class NAryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        //层序遍历
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }

    public List<Integer> postorder1(Node root) {
        //迭代 后序
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children) {
                stack.add(node);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorder(Node root) {
        //递归 后序
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    private void post(Node root, List<Integer> list) {
        if (root == null)
            return;
        for(Node node: root.children)
            list.addAll(postorder(node));
        list.add(root.val);
    }

}
