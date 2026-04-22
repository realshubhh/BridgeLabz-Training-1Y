// LeetCode #110 - Balanced Binary Tree
// Determine if a binary tree is height-balanced (every node's subtrees differ by at most 1).
// Time: O(n), Space: O(h)

public class BalancedBinaryTree {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Returns height if balanced, -1 if not balanced
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left  = checkHeight(node.left);
        if (left  == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        BalancedBinaryTree sol = new BalancedBinaryTree();

        // Balanced: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9); t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15); t1.right.right = new TreeNode(7);
        System.out.println("Balanced: " + sol.isBalanced(t1)); // true

        // Unbalanced: [1,2,2,3,3,null,null,4,4]
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2); t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(3); t2.left.right = new TreeNode(3);
        t2.left.left.left = new TreeNode(4); t2.left.left.right = new TreeNode(4);
        System.out.println("Balanced: " + sol.isBalanced(t2)); // false
    }
}
