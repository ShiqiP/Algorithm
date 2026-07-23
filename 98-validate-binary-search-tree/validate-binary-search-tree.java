/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // get the largest from the left
        // get the smallest from the right
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        // if (root.left != null && root.left.val >= root.val) 
        //     return false;
        // if (root.right != null && root.right.val <= root.val)
        //     return false;


        int leftMax = getMax(root.left);
        int rightMin = getMin(root.right);

        System.out.println("leftMax " + leftMax);
        System.out.println("rightMin " + rightMin);
        boolean current = (root.left == null || leftMax < root.val) 
                        && (root.right == null || rightMin > root.val);
        System.out.println("current " + current);

        return isValidBST(root.left) && isValidBST(root.right) && current;

    }

    public int getMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));
    }

    public int getMin(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.val, Math.min(getMin(root.left), getMin(root.right)));
    }
}