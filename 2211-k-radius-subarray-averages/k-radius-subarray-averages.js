/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var getAverages = function(nums, k) {
    const N = nums.length;
    let avgs = new Array(N).fill(-1);
    let presum = [];
    const window = 2 * k + 1;
    if(k === 0) return nums;
    if(window > N) return avgs;
    presum[0] = nums[0];
    for(let i = 1; i < nums.length; i++){
        presum[i] = presum[i - 1] + nums[i];
    }
    for(let i = k; i < N - k; i++){
        let deductedpart = (i - k) <= 0 ? 0 : presum[i - k - 1];
        avgs[i] = Math.floor((presum[i + k] - deductedpart) / window);
    }
    return avgs;
};