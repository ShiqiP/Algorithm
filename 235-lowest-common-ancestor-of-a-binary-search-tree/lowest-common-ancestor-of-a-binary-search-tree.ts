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

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
    let stack1 = [];
    let stack2 = [];
    BS(root, p, stack1);
    BS(root, q, stack2);
    let i = 0;
    while (i < stack1.length && i < stack2.length) {
        if (stack1[i].val === stack2[i].val) {
            i++;
        } else {
            break;
        }
    }
    return stack1[--i];
    function BS(root: TreeNode | null, target: TreeNode | null, stack: TreeNode[]) {
        if (root === null) return;
        stack.push(root);
        if (root.val == target.val) {
            return;
        }
        if (root.val > target.val) {
            BS(root.left, target, stack);
        } else {
            BS(root.right, target, stack);
        }
        return;
    }
};