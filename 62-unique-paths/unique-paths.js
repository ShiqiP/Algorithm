/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    // right or down
    let memo = new Array(m).fill().map(() => new Array(n).fill(0));
    memo[0][0] = 1;
    // buttom-up
    for (let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++){
            if(i > 0){
                memo[i][j] += memo[i-1][j]
            }
            if(j > 0){
                memo[i][j] += memo[i][j-1];
            }
        }
    }
    return memo[m-1][n-1];
};