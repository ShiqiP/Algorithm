/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let max = -Infinity;
    let sum = 0;

    for(let n of nums){
        sum = Math.max(sum + n , n);
        max = Math.max(max, sum);
    }

    return max;  
};