/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    let ans = [];
    for(let i = 0; i < numRows; i++ ){
        let array = new Array(i+1).fill(1);
        ans.push(array);
        for(let j = 0; j < array.length; j++){
            if(j > 0 && j < array.length - 1){
                ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
            }
        }
    }
    return ans;
};