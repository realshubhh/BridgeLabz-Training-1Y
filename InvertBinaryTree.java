// LeetCode #226 - Invert Binary Tree
// Invert a binary tree (mirror it).
// Time: O(n), Space: O(h) where h is height

import java.util.*;

public class InvertBinaryTree {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Recursive DFS
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp  = root.left;
        root.left      = invertTree(root.right);
        root.right     = invertTree(temp);
        return root;
    }

    // BFS (iterative)
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode temp  = node.left;
            node.left  = node.right;
            node.right = temp;
            if (node.left  != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return root;
    }

    static String levelOrder(TreeNode root) {
        if (root == null) return "[]";
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            res.add(n.val);
            if (n.left  != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //       4
        //      / \
        //     2   7
        //    /\   /\
        //   1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left  = new TreeNode(2); root.right = new TreeNode(7);
        root.left.left  = new TreeNode(1); root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6); root.right.right= new TreeNode(9);

        System.out.println("Before: " + levelOrder(root));
        new InvertBinaryTree().invertTree(root);
        System.out.println("After : " + levelOrder(root));  // [4, 7, 2, 9, 6, 3, 1]
    }
}
