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
    int depth;
    TreeNode node;

    Pair(TreeNode node, int depth) {
        this.depth = depth;
        this.node = node;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;

        Stack<Pair> stack = new Stack<>();

        stack.add(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;

            if(pair.node.left != null) stack.push(new Pair(node.left, pair.depth + 1));
            if(pair.node.right != null) stack.push(new Pair(node.right, pair.depth + 1));

            ans = Math.max(ans, pair.depth);
        }

        return ans;
    }
}