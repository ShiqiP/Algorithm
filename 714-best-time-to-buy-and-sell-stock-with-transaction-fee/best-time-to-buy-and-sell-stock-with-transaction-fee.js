/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
    const n = prices.length;
    let dp = new Array(n + 1).fill(0).map(() => new Array(2).fill(0));
    // i represents day
    // holding represents wether I am holding the stock
    for(let i = n - 1; i >= 0; i--){
        for(let holding = 0; holding < 2; holding ++){
            // skip today no operation today
            let profit = dp[i + 1][holding];
            // do operation
            // sale
            if(holding === 1){
                profit = Math.max(profit, prices[i] + dp[i + 1][0] - fee);
            }
            // buy
            else{
                profit = Math.max(profit, -prices[i] + dp[i + 1][1]);
            }
            dp[i][holding] = profit;
        }
    }
    return dp[0][0];
};