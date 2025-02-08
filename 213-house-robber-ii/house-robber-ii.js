/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    let map = new Map();
    let dp = (i, curSum, flag) => {
        // base cases
        if (i >= nums.length) {
            return curSum;
        }
        if (flag === 0 && i === nums.length - 1) {
            return curSum;
        }
        const key = i + ',' + curSum + ',' + flag;
        if(map.has(key)){
            return map.get(key);
        }
        const skip = dp(i + 1, curSum, flag);
        const rob = dp(i + 2, curSum + nums[i], flag)
        const ans = Math.max(skip, rob);
        map.set(key,ans);
        return ans;
    }
    let ans = nums.length === 1 ? nums[0] : Math.max(dp(0, 0, 0), dp(1, 0, 1));

    return ans;
}