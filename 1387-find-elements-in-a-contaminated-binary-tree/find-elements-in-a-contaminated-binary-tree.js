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
 */
var FindElements = function (root) {
    this.root = root;
};

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function (target) {

    let backtrack = (node, val) => {
        if (node === null) {
            return false;
        }
        if (val === target) {
            return true;
        }
        // left
        if (backtrack(node.left, 2 * val + 1)) {
            return true;
        }
        if (backtrack(node.right, 2 * val + 2)) {
            return true;
        }
        return false;
    }
    return backtrack(this.root, 0);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */