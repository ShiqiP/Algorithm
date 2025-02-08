/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function (nums, target) {
    let memo = new Map();
    /**
        i represents the position of element
        curSum represents the sum of the previous i + 1 elements
     */
    const dp = (i, curSum) => {
        // base case
        if (i === nums.length) {
            return curSum === target ? 1 : 0;
        }
        const key = i + ',' + curSum
        if (memo.has(key)) return memo.get(key);

        let ans = dp(i + 1, curSum + nums[i]) + dp(i + 1, curSum - nums[i])
        memo.set(key, ans)
        return ans;
    }
    const ans = dp(0, 0)
    return ans;
};