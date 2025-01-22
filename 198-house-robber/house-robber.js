/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    // bottom-up
    let dp = new Array(nums.length);
    for(let i=0;i<nums.length;i++){
        if(i == 0){
            dp[0] = nums[0];
            continue;
        }
        if(i == 1){
            dp[1] = Math.max(nums[0],nums[1]);
            continue;
        }
        dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
    }
    console.log(dp)
    return dp[dp.length-1];

};