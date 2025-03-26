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

function isEvenOddTree(root: TreeNode | null): boolean {
    let queue = [];
    let preLevel = 0;
    let preVal = null;
    queue.push([root, 0]);
    while (queue.length) {
        const [node, nodeLevel] = queue.shift();
        if (node.left) {
            queue.push([node.left, nodeLevel + 1]);
        }
        if (node.right) {
            queue.push([node.right, nodeLevel + 1]);
        }
        if (nodeLevel % 2 === 0) {
            if (preLevel === nodeLevel && preVal >= node.val)
                return false;
            if (node.val % 2 === 0)
                return false;
        }
        if (nodeLevel % 2 === 1) {
            if (preLevel === nodeLevel && preVal <= node.val)
                return false;
            if (node.val % 2 === 1)
                return false;
        }
        preLevel = nodeLevel;
        preVal = node.val;
    }

    return true;
};