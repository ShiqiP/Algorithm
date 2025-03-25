/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function longestZigZag(root: TreeNode | null): number {

    let dfs = (node: TreeNode | null, length: number, direction: boolean) => {
        if (node === null) return 0;
        if (node.left === null && node.right === null) return length;
        let ans = length;
        // previous direction
        // left
        if (direction) {
            ans = Math.max(ans, dfs(node.left, 1, true), dfs(node.right, length + 1, false))
        } else {
            //right
            //  0,1 + 0
            ans = Math.max(ans, dfs(node.right, 1, false), dfs(node.left, length + 1, true));
        }
        return ans;
    }
    return dfs(root, 0, true);
};