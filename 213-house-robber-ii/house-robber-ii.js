/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    const n = nums.length;
    if (nums.length === 1) {
        return nums[0]
    }
    let dp = (start, end) => {
        let t1 = 0;
        let t2 = 0;
        for (let i = start; i <= end; i++) {
            let temp = t1;
            // get the cur 
            t1 = Math.max(t2 + nums[i], t1)
            t2 = temp;
        }
        return t1;
    }

    return Math.max(dp(0, n - 2), dp(1, n - 1));
}