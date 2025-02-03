/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function (n) {
    // time complexity O(n)
    // space complexity O(n)
    let memo = new Array(n+1).fill(-1);
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 1;
    let dp = (n)=>{
        if(memo[n] !== -1){
            return memo[n];
        }
        memo[n] = dp(n - 1) + dp(n - 2) + dp(n - 3)
        return memo[n];
    }
    return dp(n);
};