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

function deleteNode(root: TreeNode | null, key: number): TreeNode | null {
    let ans = deleteFunc(root, key)
    return ans;

    function deleteFunc(node: TreeNode | null, key: number) {
        if (node === null) return node;
        if (node.val === key) {
            let left = node.left;
            let right = node.right;
            if(left === null || right === null) return left === null ? right : left;
            let rightLeft = right;
            while(rightLeft !== null && rightLeft.left !== null){
                rightLeft = rightLeft.left;
            }
            rightLeft.left = left;
            return right;
        }
        else if (node.val > key) {
            node.left = deleteFunc(node.left, key);
        } else {
            node.right = deleteFunc(node.right, key)
        }

        return node;
    }

};