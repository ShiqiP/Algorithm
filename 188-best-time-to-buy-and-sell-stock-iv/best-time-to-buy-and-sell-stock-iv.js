/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (k, prices) {
    // top-down
    // i day 
    // holding we are holding stock or not
    // remain how many transaction we have
    // reserved 0 index for remain we just use 1 - k position 
    let memo = new Array(prices.length).fill(0).map(() => new Array(2).fill(0).map(() => new Array(k+1).fill(-1)));
    let dp = (i, holding, remain) => {
        // base cases
        if (remain == 0) return 0;
        if (i == prices.length) return 0;
        if (memo[i][holding][remain] !== -1) {
            return memo[i][holding][remain];
        }
        let maxProfit = dp(i + 1, holding, remain);
        // recurrance relation  
        if (holding) {
            // sell or not
            const sellProfit = prices[i] + dp(i + 1, 0, remain - 1);
            maxProfit = Math.max(sellProfit, maxProfit);
        } else {
            // buy or not 
            const buyProfit = -prices[i] + dp(i + 1, 1, remain);
            maxProfit = Math.max(buyProfit, maxProfit);
        }
        memo[i][holding][remain] = maxProfit;
        return maxProfit;
    }
    return dp(0, 0, k);
};