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
    this.values = new Set();
    this.recover(this.root, 0);
};

FindElements.prototype.recover = function (node, val) {
    if (!node) return;
    this.values.add(val);

    this.recover(node.left, 2 * val + 1);
    this.recover(node.right, 2 * val + 2);
}

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function (target) {
   return this.values.has(target);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */