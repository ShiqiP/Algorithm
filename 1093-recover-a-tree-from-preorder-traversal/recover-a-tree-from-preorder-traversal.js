/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {string} traversal
 * @return {TreeNode}
 */
var recoverFromPreorder = function (traversal) {
    let map = []; // level - val
    let level = 0;
    let numArr = [];
    const str = traversal + '-';
    // [0, 1] [1, 401], [2, 349] [3, 90] [2, 88]
    for (let i = 0; i < str.length; i++) {
        let c = str[i];
        if (c === '-') {
            // preNode
            if (numArr.length > 0) {
                map.push([level, +numArr.join('')]);
                numArr = [];
                level = 0;
            }
            level++;
        } else {
            numArr.push(c);
        }
    }
    let formTree = (index, depth) => {
        for (let i = index; i < map.length; i++) {
            let element = map[i];
            let level = element[0];
            let val = element[1];
            if(level < depth) return null;
            if (level === depth) {
                let leftChild = null;
                let rightChild = null;
                if(i + 1 < map.length && map[i+1][0] > level){
                    leftChild = formTree(i + 1, level + 1);
                    rightChild = formTree(i + 2, level + 1)
                }
                let root = new TreeNode(val, leftChild, rightChild);
                return root;
            }
        }
        return null;
    }
    return formTree(0, 0);
};