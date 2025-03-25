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

function averageOfLevels(root: TreeNode | null): number[] {
    let queue = [];
    let level = 0;
    let count = 0;
    let sum = 0;
    let ans = [];
    queue.push([root, 0]);
    while (queue.length > 0) {
        const [node, nodeLevel] = queue.shift();
        if (level === nodeLevel) {
            sum += node.val;
            count ++;
        }else{
            ans[level] = sum / count;
            sum = node.val;
            level = nodeLevel;
            count = 1;
        }
        if(node.left){
            queue.push([node.left, nodeLevel + 1]);
        }
        if(node.right){
            queue.push([node.right, nodeLevel + 1]);
        }
    }
    ans[level] = sum / count;
    return ans;
};