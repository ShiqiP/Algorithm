/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    // bottom-up
    const m = grid.length;
    const n = grid[0].length;
    let dp = new Array(m).fill(0).map(() => new Array(n).fill(0));
    dp[0][0] = grid[0][0];

    for(let i=0; i<m; i++){
        for(let j=0; j<n; j++){
            let res = Infinity;
            if(i + j === 0){
                continue;
            }
            if(i > 0){
                res = Math.min(res, dp[i-1][j]);
            }
            if(j > 0){
                res = Math.min(res, dp[i][j-1]);
            }
            dp[i][j] += res + grid[i][j];
        }
    }
    return dp[m-1][n-1];
};