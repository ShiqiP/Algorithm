/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
    const n = matrix.length
    let memo = new Array(n).fill().map(() => new Array(n).fill(null));

    let dp = (row, col) => {
        // base cases
        if (col < 0 || col >= n) return Infinity;
        if (row === n - 1) return matrix[row][col];
        if (memo[row][col] !== null) return memo[row][col];
        let down = dp(row + 1, col);
        let left = dp(row + 1, col - 1);
        let right = dp(row + 1, col + 1);

        memo[row][col] = matrix[row][col] + Math.min(down, left, right);
        return memo[row][col];
    }
    let minFallingSum = Infinity;
    for (let col = 0; col < n; col++) {
        minFallingSum = Math.min(minFallingSum, dp(0, col));
    }
    return minFallingSum;
};