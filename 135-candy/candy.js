/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function (ratings) {
    const n = ratings.length;
    let right2left = new Array(n).fill(1);
    let left2right = new Array(n).fill(1);
    let ans = 0;
    for(let i = 1; i < n; i++){
        if(ratings[i] > ratings[i-1]){
            left2right[i] = left2right[i-1] + 1;
        }
    }
    for(let i = n - 1; i >= 0; i--){
        if(ratings[i] > ratings[i+1]){
            right2left[i] = right2left[i+1] + 1;
        }
    }
    for(let i = 0; i < n; i++){
        ans += Math.max(right2left[i], left2right[i]);
    }
    return ans;
};