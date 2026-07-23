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
class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node,
            int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        return dfs(root, 0).node;
    }

    public Pair dfs(TreeNode root, int depth) {
        // bfs
        if (root == null)
            return new Pair(root, depth);

        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);

        if (left.depth == right.depth)
            return new Pair(root, left.depth);
        
        else{
            return left.depth > right.depth ? left : right;
        }
    }

}