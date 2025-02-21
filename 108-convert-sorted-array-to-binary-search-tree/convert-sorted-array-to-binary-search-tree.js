/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
    if (nums.length === 1) {
        return new TreeNode(nums[0], null, null);
    }
    const n = nums.length;
    let mid = Math.floor(n / 2);
    let leftNode = null;
    let rightNode = null;
    if (mid - 1 >= 0) {
        leftNode = sortedArrayToBST(nums.slice(0, mid));
    }
    if (mid + 1 <= n - 1) {
        rightNode = sortedArrayToBST(nums.slice(mid + 1, n));
    }
    let node = new TreeNode(nums[mid], leftNode, rightNode);
    return node;

}