function maxProfit(prices: number[]): number {  
    let ans = 0; // sum of the profit
    for(let i = 0; i < prices.length - 1; i++){
        if(prices[i + 1] > prices[i]){
            ans += prices[i + 1] - prices[i];
        }
    }
    return ans;
};