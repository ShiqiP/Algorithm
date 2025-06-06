/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
    // longest of 
    // deciding to use the letter or not affects the future letters we can take
    // bottom-up
    const n = text1.length;
    const m = text2.length;
    let dp = new Array(n+1).fill(0).map(()=> new Array(m+1).fill(0));

    for(let i=n-1; i>=0; i--){
        for(let j=m-1; j>=0; j--){
            if(text1[i] == text2[j]){
                dp[i][j] = dp[i+1][j+1] + 1; 
            }else{
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    return dp[0][0];
};