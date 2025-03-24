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

function pathSum(root: TreeNode | null, targetSum: number): number {
    let dfs = (root: TreeNode | null, sum: number, list: number[]) => {
        let ans = 0;
        if (root === null) return ans;
        let curSum = root.val + sum;
        let curList = [...list, root.val];
        if (curSum === targetSum) ans++;
        let temp = [...curList];
        let tempSum = curSum;
        while (temp.length > 1) {
            tempSum -= temp.shift();
            if (tempSum === targetSum) {
                ans++;
            }
        }

        if (root.left) {
            ans += dfs(root.left, curSum, curList)
        }
        if (root.right) {
            ans += dfs(root.right, curSum, curList)
        }
        return ans;
    }
    return dfs(root, 0, []);
};