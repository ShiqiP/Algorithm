/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubArrayLen = function (nums, k) {


    // preSumArr map preSum -> index;
    // traverse preSumArr if(map.has(preSum - k)) curIndex - map.get(preSum - k)[0];
    const n = nums.length;
    let preSumArr = [];
    let map = new Map();
    let ans = 0;
    for (let i = 0; i < n; i++) {
        if(i === 0)
            preSumArr[0] = nums[0];
        else
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        if (map.has(preSumArr[i] - k)) {
            ans = Math.max(i - map.get(preSumArr[i] - k), ans);
        }
        if (preSumArr[i] === k) {
            ans = Math.max(i + 1, ans);
        }
        if (!map.has(preSumArr[i])) {
            map.set(preSumArr[i], i);
        }
    }

    return ans;
};