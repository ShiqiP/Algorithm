/**
 * @param {number[]} preorder
 * @return {boolean}
 */

var verifyPreorder = function (preorder) {

    //  how to get the preorder
    var curNode = 0
    return check(-Infinity, Infinity);
    // curNode 
    // 5, -Infinity, 5
    // 2, 
    // 1, -Infinity, 2
    // 3 
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