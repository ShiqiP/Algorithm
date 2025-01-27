/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
    // longest of 
    // deciding to use the letter or not affects the future letters we can take
    // top-down
    let arr = new Array(text1.length).fill(0).map(() => new Array(text2.length).fill(-1));
    let dp = (i, j) => {
        // base cases
        if (i === text1.length || j === text2.length) {
            return 0;
        }
        // const key = i + ',' + j;
        // if (map.has(key)) {
        //     return map.get(key)
        // }
        if (arr[i][j] !== -1) {
            return arr[i][j];
        }
        let ans;
        if (text1[i] === text2[j]) {
            ans = dp(i + 1, j + 1) + 1;
        } else {
            ans = Math.max(dp(i, j + 1), dp(i + 1, j));
        }
        // map.set(key, ans);
        arr[i][j] = ans;
        return ans;
    }
    return dp(0, 0);
};