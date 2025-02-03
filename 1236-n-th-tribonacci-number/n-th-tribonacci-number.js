/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    // time complexity O(n)
    // space complexity O(n)
    let T = new Array(n+1).fill(0);
    T[0] = 0;
    T[1] = 1;
    T[2] = 1;
    for(let i = 3; i <= n; i++){
        T[i] = T[i-1] + T[i-2] + T[i-3];
    }
    return T[n];
};