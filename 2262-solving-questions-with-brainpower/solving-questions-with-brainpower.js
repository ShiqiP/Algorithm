/**
 * @param {number[][]} questions
 * @return {number}
 */
var mostPoints = function (questions) {

    let memo = new Array(questions.length).fill(0);
    let max = 0;
    return dp(0);
    function dp(i) {
        // base case
        if(i >= questions.length){
            return 0;
        }
        if(memo[i] !== 0){
            return memo[i];
        }
        // recurrance relation
        memo[i] = Math.max(questions[i][0] + dp(i + questions[i][1] + 1), dp(i + 1))
        
        return memo[i];
    }

};