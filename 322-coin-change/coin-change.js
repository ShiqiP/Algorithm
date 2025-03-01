/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */

// [1,2,5]  11 5+5+1 3
// if I want the fewest number of coins
// first we start from the largest denomination coin
var coinChange = function (coins, amount) {
    const n = amount;
    // the minimum number of coins can make up to specific amount;
    // index represents specific amount;
    let arr = new Array(n + 1).fill(-1);
    arr[0] = 0;
    for (const coin of coins) {
        for (let i = 0; i <= amount; i++) {
            if (i - coin >= 0 && arr[i - coin] != -1) {
                const cur = arr[i - coin] + 1;
                arr[i] = arr[i] === -1 ? cur : Math.min(cur, arr[i]);
            }
        }
    }
    return arr[n];
};