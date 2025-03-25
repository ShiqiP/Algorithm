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

function levelOrder(root: TreeNode | null): number[][] {
    if(root === null) return [];
    let queue = [];
    let ans = [];
    queue.push([root, 0]);
    while (queue.length > 0) {
        const [node, level] = queue.shift();
        if (ans[level]) {
            ans[level].push(node.val);
        } else {
            ans[level] = [node.val];
        }
        if (node.left) {
            queue.push([node.left, level + 1]);
        }
        if (node.right) {
            queue.push([node.right, level + 1]);
        }
    }
    return ans;
};