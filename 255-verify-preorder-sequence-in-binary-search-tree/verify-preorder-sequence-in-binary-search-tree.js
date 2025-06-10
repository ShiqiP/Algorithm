/**
 * @param {number[]} preorder
 * @return {boolean}
 */

var verifyPreorder = function (preorder) {
    let stack = [];
    let minLimit = -Infinity;

    for (let i = 0; i < preorder.length; i++){
        const num = preorder[i];
        // find the root
        while(stack.length > 0 && stack[stack.length - 1] < num){
            minLimit = stack.pop();
        }
        // it cannot be rightchild
        if(num <= minLimit){
            return false;
        }

        //left child
        stack.push(num);
    }
    return true;
};