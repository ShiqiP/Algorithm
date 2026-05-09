function maxProfit(prices: number[]): number {
    let maxProfits = new Array(prices.length).fill(0);
    for (let k = 1; k < 3; k++) {
        let minCost = prices[0];
        let profit = 0;
        for (let i = 1; i < prices.length; i++) {
            minCost = Math.min(prices[i] - maxProfits[i], minCost);
            profit = Math.max(prices[i] - minCost, profit);
            maxProfits[i] = profit;
        }
    }
    return maxProfits[prices.length - 1];
};