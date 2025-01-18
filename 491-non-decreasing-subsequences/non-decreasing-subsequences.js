/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findSubsequences = function (nums) {
    let result =[];
    let map = {};
    backtrack([],0);
    return result;

    function backtrack(cur,index) {
        if(map[cur]) return;
        if (index > nums.length) {
            return;
        }
        if (cur.length >= 2) {
            result.push(cur.concat());
        }
        for (let i=index; i<nums.length; i++) {
            const key = nums[i];
            // non-decreasing
            if (cur.length > 0 && cur[cur.length - 1] > key) {
                continue;
            }
            map[cur] = true;
            backtrack([...cur,key],i+1);
        }

    }
};