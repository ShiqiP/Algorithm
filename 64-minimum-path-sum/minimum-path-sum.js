/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    // bottom-up
    const m = grid.length;
    const n = grid[0].length;
    let dp = new Array(n).fill(0);
    dp[0] = grid[0][0];

    for (let i = 0; i < m; i++) {
        let preRow = dp.concat([]);
        for (let j = 0; j < n; j++) {
            let res = Infinity;
            if (i + j === 0) {
                continue;
            }
            if (i > 0) {
                res = Math.min(res, preRow[j]);
            }
            if (j > 0) {
                res = Math.min(res, preRow[j - 1]);
            }
            preRow[j] = res + grid[i][j];
        }
        dp = preRow.concat([]);
    }
    return dp[n - 1];
};