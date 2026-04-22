// LeetCode #543 - Diameter of Binary Tree
// Find the length of the longest path between any two nodes in the tree.
// Time: O(n), Space: O(h)

public class DiameterOfBinaryTree {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left  = depth(node.left);
        int right = depth(node.right);
        diameter  = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();

        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter: " + sol.diameterOfBinaryTree(root)); // 3 (path: 4->2->1->3 or 5->2->1->3)

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Diameter: " + sol.diameterOfBinaryTree(root2)); // 1
    }
}
