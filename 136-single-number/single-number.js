/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let mask = 0;
    for(let i = 0; i < nums.length; i++){
        mask ^= nums[i];
    }
    return mask;
};