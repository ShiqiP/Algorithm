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
    const arr1 = preOrder(root1);
    const arr2 = preOrder(root2);
    let ans = [];
    let i = 0, j = 0;
    while(i < arr1.length && j < arr2.length){
        if(arr1[i] <= arr2[j]){
            ans.push(arr1[i++]);
        }else{
            ans.push(arr2[j++]);
        }
    }
    while(i < arr1.length){
        ans.push(arr1[i++]);
    }
    while(j < arr2.length){
        ans.push(arr2[j++]);
    }
    return ans;
    // preOrder     
    function preOrder(root: TreeNode | null) : number[]{
        if(root === null) return [];
        let ans = [];
        ans.push(...preOrder(root.left));
        ans.push(root.val);
        ans.push(...preOrder(root.right));
        return ans;
    }
};