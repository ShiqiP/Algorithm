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

function getAllElements(root1: TreeNode | null, root2: TreeNode | null): number[] {
    let arr1 = [], arr2 = [];
    inOrder(root1, arr1);
    inOrder(root2, arr2);
    let ans = [];
    let i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            ans.push(arr1[i++]);
        } else {
            ans.push(arr2[j++]);
        }
    }
    while (i < arr1.length) {
        ans.push(arr1[i++]);
    }
    while (j < arr2.length) {
        ans.push(arr2[j++]);
    }
    return ans;
    // inOrder     
    function inOrder(root: TreeNode | null, ans: number[]): number[] {
        if (root === null) return ans;
        inOrder(root.left, ans)
        ans.push(root.val);
        inOrder(root.right, ans)
        return ans;
    }
};