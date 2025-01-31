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
        if (memo[row][col] !== -1) {
            return memo[row][col];
        }
        // recurrance relation
        let ans = Infinity
        if(row > 0){
            ans = Math.min(ans, dp(row-1, col));
        }
        if(col > 0){
            ans = Math.min(ans, dp(row, col - 1));
        }
        memo[row][col] = ans + grid[row][col];
        return memo[row][col];
    }
    return dp(m - 1, n - 1);
};