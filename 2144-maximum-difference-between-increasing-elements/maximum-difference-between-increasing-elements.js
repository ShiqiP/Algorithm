/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumDifference = function(nums) {
    let ans = -1;
    let minPre = nums[0]
    for(let i = 1; i < nums.length; i++){
        if(minPre < nums[i]){
            ans = Math.max(ans, nums[i] - minPre);
        }
        minPre = Math.min(minPre, nums[i]);
    }
    return ans;
};