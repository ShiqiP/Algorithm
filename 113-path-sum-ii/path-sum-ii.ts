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

function pathSum(root: TreeNode | null, targetSum: number): number[][] {
    let ans: number[][] = [];
    function dfs(root: TreeNode | null, sum: number, list: number[]) {
        if (root === null) return;

        if (root.left === null && root.right === null) {
            if (sum + root.val === targetSum) {
                ans.push([...list, root.val]);
            }
            return;
        }
        let curSum = sum + root.val;
        let curList = [...list, root.val];
        dfs(root.left, curSum, curList);
        dfs(root.right, curSum, curList);
        return;
    }
    dfs(root, 0, []);
    return ans;
};