/**
 * @param {number[][]} piles
 * @param {number} k
 * @return {number}
 */
var maxValueOfCoins = function (piles, k) {
    const n = piles.length;
    let memo = new Array(n + 1).fill(0).map(() => new Array(k + 1).fill(0));
    for (let i = n - 1; i >= 0; i--) {
        for (let remain = 1; remain <= k; remain++) {
            memo[i][remain] = memo[i + 1][remain]; // skip this pile
            let cur = 0;
            for (let j = 0; j < Math.min(remain, piles[i].length); j++) {
                cur += piles[i][j];
                memo[i][remain] = Math.max(cur + memo[i + 1][remain - j - 1], memo[i][remain]);
            }
        }
    }
    return memo[0][k];
};