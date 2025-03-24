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

function isSymmetric(root: TreeNode | null): boolean {

    function dfs(node1: TreeNode | null, node2: TreeNode | null) {
        
        if(node1 === null && node2 === null) return true;
        if(node1 === null || node2 === null) return false;
        if (node1.val === node2.val)
            return dfs(node1.left, node2.right) && dfs(node1.right,node2.left);
        return false;
    }
    if(root === null) return true;
    return dfs(root.left, root.right)
};