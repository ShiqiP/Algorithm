/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let left = 0, right = 1;
    while (right < nums.length && left < right) {
        if (nums[left] !== nums[right]) {
            nums[++left] = nums[right];
            right++;
        } else {
            right++;
        }
    }
    // console.log(left)
    // console.log(left + 1)
    return left + 1;
};