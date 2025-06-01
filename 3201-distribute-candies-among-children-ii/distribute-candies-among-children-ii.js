/**
 * @param {number} n
 * @param {number} limit
 * @return {number}
 */
var distributeCandies = function(n, limit) {
    let answer = 0;
    for(let a = Math.max(0, n - 2 * limit); a <= Math.min(limit,n); a++){
        let b = Math.min(limit, n - a) - Math.max(0 , n - a - limit) + 1;
        answer += Math.max(0, b);
    }
    return answer;
};  