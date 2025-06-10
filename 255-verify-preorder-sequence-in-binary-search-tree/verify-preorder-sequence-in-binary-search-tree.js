/**
 * @param {number[]} preorder
 * @return {boolean}
 */

var verifyPreorder = function (preorder) {

    //  how to get the preorder
    var curNode = 0
    return check(-Infinity, Infinity);
    // curNode 
    // 5, -Infinity, Infinity
    // 2, -Infinity, 5 left
    // 1, -Infinity, 2 left
    // 3, -Infinity, 1 left false
    // 3, 1,2 right false
    // backtrack
    // 3 , 2, 5 right
    // 6 , 5, infinity/
    function check(minLimit, maxlimit) {
        if (curNode == preorder.length) return true;

        const root = preorder[curNode];
        if (root <= minLimit || root >= maxlimit) {
            return false;
        }
        curNode++;
        let left = check(minLimit, root);
        let right = check(root, maxlimit);

        return left || right;
    }
};