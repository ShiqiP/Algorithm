/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function(nums) {
    const len = nums[0].length;
    let backtrack = (cur) => {
        if(cur.length === len){
            return;
        }
        for(let i = 0; i <= 1; i++){
            cur.push(i);
            backtrack(cur);
            if(cur.length === len && !nums.includes(cur.join(''))){
                return cur.join('');
            }
            cur.pop();
        }
    }
    return backtrack([])
};