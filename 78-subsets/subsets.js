/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let ans = [];
    const n = nums.length;

    let backtrack = (cur, index) => {
        ans.push([...cur]);
        if(index >= n){
            return;
        }
        for(let i = index; i < n; i++){
            cur.push(nums[i]);
            backtrack(cur, i + 1);
            cur.pop();
        }
    }
    backtrack([], 0);
    return ans;
};