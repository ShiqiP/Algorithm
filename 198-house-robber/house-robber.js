/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    // bottom-up optimized space complexity
    if(nums.length == 1) return nums[0]
    let backOne =  Math.max(nums[0],nums[1]);
    let backTwo = nums[0];

    for(let i=2;i<nums.length;i++){
        let temp = backOne;
        backOne = Math.max(backOne,backTwo + nums[i]);
        backTwo = temp;
    }
    return backOne;

};