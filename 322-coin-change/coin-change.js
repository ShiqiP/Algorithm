/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */

// [1,2,5]  11 5+5+1 3
// if I want the fewest number of coins
// first we start from the largest denomination coin
var coinChange = function (coins, amount) {
    // the fewest number of coins to make up certain amount;
    // from 0 - amount;
    let memo = new Array(amount + 1).fill(amount + 1);
    memo[0] = 0;
    dp(amount);
    return memo[amount];

    function dp(remain) {
        if (remain == 0) return 0;
        if (remain < 0) return -1;
        if (memo[remain] !== amount + 1) return memo[remain];

        for (let c of coins) {
            // recurrance relation
            // previous coins that make up remain-c
            const pre = dp(remain - c);
            if (pre === -1) continue;
            memo[remain] = Math.min(memo[remain], pre + 1);
        }
        memo[remain] = memo[remain] === amount + 1 ? -1 : memo[remain];
        return memo[remain];
    }
};