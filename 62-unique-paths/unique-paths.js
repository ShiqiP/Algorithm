/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    // right or down
    let memo = new Array(m).fill(0).map(() => new Array(n).fill(-1));
    memo[0][0] = 1;

    let dp = (row, col) => {
        // base cases
        if (row < 0 || col < 0) {
            return 0;
        }
        if (memo[row][col] !== -1) {
            return memo[row][col];
        }
        // recurrance relation
        // posibilitis from left or up
        memo[row][col] = dp(row - 1, col) + dp(row, col - 1);
        return memo[row][col];
    }
    return dp(m - 1, n - 1);
};