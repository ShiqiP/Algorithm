/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    const m = grid.length;
    const n = grid[0].length;
    let memo = new Array(m).fill().map(() => new Array(n).fill(-1));
    memo[0][0] = grid[0][0]
    let dp = (row, col) => {
        // base cases
        if (row < 0 || col < 0) {
            return -1;
        }
        if (memo[row][col] !== -1) {
            return memo[row][col];
        }
        // recurrance relation
        const preCol = dp(row, col - 1)
        const preRow = dp(row - 1, col)
        if (preCol !== -1 && preRow !== -1) {
            memo[row][col] = Math.min(preCol, preRow);
        } else if (preCol === -1) {
            memo[row][col] = preRow;
        } else if (preRow === -1) {
            memo[row][col] = preCol;
        }
        memo[row][col] += grid[row][col];
        return memo[row][col];
    }
    return dp(m - 1, n - 1);
};