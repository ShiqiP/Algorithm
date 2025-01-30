/**
 * @param {number[][]} piles
 * @param {number} k
 * @return {number}
 */
var maxValueOfCoins = function (piles, k) {
    let memo = new Array(piles.length).fill(0).map(() => new Array(k + 1).fill(-1));
    let dp = (i, remain) => {
        // base cases
        if (remain == 0) return 0;
        if (i == piles.length) return 0;
        if (memo[i][remain] !== -1) {
            return memo[i][remain];
        }
        // skip
        let res = dp(i + 1, remain);
        let cur = 0;
        // choose current pile 
        for (let j = 0; j < Math.min(remain, piles[i].length); j++) {
            cur += piles[i][j];
            // skip
            res = Math.max(res, cur + dp(i + 1, remain - 1 - j));
        }
        memo[i][remain] = res;
        return res;
    }
    return dp(0, k);
};