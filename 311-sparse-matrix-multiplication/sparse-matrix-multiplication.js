/**
 * @param {number[][]} mat1
 * @param {number[][]} mat2
 * @return {number[][]}
 */
var multiply = function(mat1, mat2) {
    const m = mat1.length;
    const k = mat1[0].length;
    const n = mat2[0].length;
    let total = 0;
    let ans = new Array(m).fill().map(() => new Array(n));
    for(let row = 0; row < m; row++){
        for(let col = 0; col < n; col++){
            let sum = 0;
            for(let i = 0; i < k; i++){
                sum += mat1[row][i] * mat2[i][col];
            }
            ans[Math.floor(total / k)][total % k] = sum;
            total++;
        }
    }
    return ans;
};