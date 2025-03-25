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

function maxLevelSum(root: TreeNode | null): number {
    let queue = [];
    let max = -Infinity;
    let ans = 0;
    let sum = max;
    let level = 0;
    queue.push([root, 1]);
    while (queue.length > 0) {
        const [node, nodeLevel] = queue.shift();
        if (level === nodeLevel) {
            sum += node.val;
        } else {
            if (sum > max) {
                ans = level;
                max = sum;
            }
            sum = node.val;
            level = nodeLevel;
        }
        if (node.left) {
            queue.push([node.left, nodeLevel + 1]);
        }
        if (node.right) {
            queue.push([node.right, nodeLevel + 1])
        }
    }
    if (sum > max) {
        ans = level;
    }
    return ans;
};