// LeetCode #572 - Subtree of Another Tree
// Check if subRoot is a subtree of root.
// Time: O(m*n), Space: O(h)

public class SubtreeOfAnotherTree {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)     return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();

        //   root:       sub:
        //      3           4
        //     / \         / \
        //    4   5       1   2
        //   / \
        //  1   2
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(4); root.right = new TreeNode(5);
        root.left.left  = new TreeNode(1); root.left.right = new TreeNode(2);

        TreeNode sub = new TreeNode(4);
        sub.left = new TreeNode(1); sub.right = new TreeNode(2);

        System.out.println(sol.isSubtree(root, sub)); // true

        root.left.right.left = new TreeNode(0); // add extra node to sub in root
        System.out.println(sol.isSubtree(root, sub)); // false
    }
}
