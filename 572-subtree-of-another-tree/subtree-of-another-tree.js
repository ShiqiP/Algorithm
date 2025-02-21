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
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function (root, subRoot) {
    let recursion = (root, subRoot, begin) => {
        if (root === null || subRoot === null) {
            return root === null && subRoot === null;
        }
        // begin 
        if (begin) {
            if (root.val === subRoot.val)
                return recursion(root.left, subRoot.left, true) && recursion(root.right, subRoot.right, true)
            else
                return false;
        } else {
            // not 
            if (root.val === subRoot.val) {
                if (recursion(root.left, subRoot.left, true) && recursion(root.right, subRoot.right, true)) {
                    return true;
                }
            }
            return recursion(root.left, subRoot, false) || recursion(root.right, subRoot, false);
        }
    }
    return recursion(root, subRoot, false);
};