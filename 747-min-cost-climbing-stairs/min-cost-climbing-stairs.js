/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {

    // bottom-up
    // includes the initial postion and the top of the floor position
    const n = cost.length;
    let dp = new Array(n+1).fill(0);
    // start form 2 cause reaching to dp[0] dp[1] cost 0;
    for(let i=2; i<=n; i++){
        dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
    }

    return dp[cost.length];
};