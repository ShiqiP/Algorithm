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
    preSumArr[0] = nums[0];
    map.set(preSumArr[0], 0);

    for (let i = 1; i < n; i++) {
        preSumArr[i] = preSumArr[i - 1] + nums[i];
        if (!map.has(preSumArr[i])) {
            map.set(preSumArr[i], i);
        }
    }
    // preSumArr = [1,0,5,3,6]
    // map = {1:0, 0:1, 5:2, 3:3, 6:4 } 
    //          3-1 + 1
    let ans = 0;
    for (let i = n - 1; i >= 0; i--) {
        if (map.has(preSumArr[i] - k)) {
            ans = Math.max(i - map.get(preSumArr[i] - k), ans);
        }
        if(preSumArr[i] === k){
            ans = Math.max(i + 1, ans);
        }
    }
    return ans;
};