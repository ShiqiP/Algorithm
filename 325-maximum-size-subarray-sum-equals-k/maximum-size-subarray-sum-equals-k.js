/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubArrayLen = function (nums, k) {


    // preSumArr map preSum -> index;
    // traverse preSumArr if(map.has(preSum - k)) curIndex - map.get(preSum - k)[0];
    const n = nums.length;
    let preSum = 0;
    let map = new Map();
    let ans = 0;
    for (let i = 0; i < n; i++) {
        preSum += nums[i]
        if (map.has(preSum - k)) {
            ans = Math.max(i - map.get(preSum - k), ans);
        }
        if (preSum === k) {
            ans = Math.max(i + 1, ans);
        }
        if (!map.has(preSum)) {
            map.set(preSum, i);
        }
    }

    return ans;
};