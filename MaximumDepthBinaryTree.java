// LeetCode #104 - Maximum Depth of Binary Tree
// Find the maximum depth (number of nodes along the longest path from root to leaf).
// Time: O(n), Space: O(h)

import java.util.*;

public class MaximumDepthBinaryTree {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Recursive DFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Iterative BFS
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left  != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        //     3
        //    / \
        //   9  20
        //      / \
        //     15   7
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left  = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthBinaryTree sol = new MaximumDepthBinaryTree();
        System.out.println("DFS depth: " + sol.maxDepth(root));    // 3
        System.out.println("BFS depth: " + sol.maxDepthBFS(root)); // 3

        TreeNode single = new TreeNode(1);
        System.out.println("Single node: " + sol.maxDepth(single)); // 1
        System.out.println("Null tree: "   + sol.maxDepth(null));    // 0
    }
}
