// LeetCode #235 - Lowest Common Ancestor of a Binary Search Tree
// Find the LCA of two nodes in a BST using BST property.
// Time: O(h), Space: O(1)

public class LowestCommonAncestorBST {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;   // both nodes in left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;  // both nodes in right subtree
            } else {
                return root;        // split point = LCA
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //         6
        //        / \
        //       2   8
        //      / \ / \
        //     0  4 7  9
        //       / \
        //      3   5
        LowestCommonAncestorBST sol = new LowestCommonAncestorBST();
        TreeNode root = new TreeNode(6);
        root.left  = new TreeNode(2); root.right = new TreeNode(8);
        root.left.left  = new TreeNode(0); root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7); root.right.right= new TreeNode(9);
        root.left.right.left  = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(sol.lowestCommonAncestor(root, root.left, root.right).val); // 6
        System.out.println(sol.lowestCommonAncestor(root, root.left, root.left.right).val); // 2
        System.out.println(sol.lowestCommonAncestor(root, root.right.left, root.right.right).val); // 8
    }
}
