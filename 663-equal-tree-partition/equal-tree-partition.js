/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var checkEqualTree = function (root) {
    let stack = [];
    const sum = (root) => {
        if (root === null) return 0;
        const sumVal = sum(root.left) + sum(root.right) + root.val;
        stack.push(sumVal);
        return sumVal;
    }
    const total = sum(root);
    stack.pop()
    if (total % 2 !== 0) return false;
    for (const val of stack) {
        if (val === total / 2) return true
    }
    return false;
};