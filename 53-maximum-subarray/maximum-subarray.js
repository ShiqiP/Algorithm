/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let max = -Infinity;
    let sum = 0;

    for(let i = 0; i < nums.length; i++){
        sum = Math.max(sum + nums[i] , nums[i]);
        max = Math.max(max, sum);
    }

    return max;  
};