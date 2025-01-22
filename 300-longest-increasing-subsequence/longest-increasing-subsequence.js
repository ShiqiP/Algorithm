/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    // top-down
    const n = nums.length;
    let memo = new Array(n).fill(0);
    let max = 0;
    for(let m in memo){
        max = Math.max(max,dp(m));
    }
    console.log(memo)
    return max;

    function dp(index){
        // base case
        if(index == 0){
            memo[0] = 1;
            return 1;
        }

        if(memo[index] > 0)
            return memo[index];
                
        memo[index] = 1
        for(let i=index; i >= 0;i--){
            if(nums[index] > nums[i]){
                memo[index] = Math.max(1 + dp(i),memo[index]);
            }
        }

        return memo[index];
    }

};