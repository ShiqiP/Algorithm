function subarraySum(nums: number[], k: number): number {
    // pre sum 

    // [1,3,6]
    let ans = 0;
    let presum:number[] = []
    presum[0] = 0;
    for(let i = 1; i <= nums.length; i++){
        presum[i] = presum[i - 1] + nums[i - 1]; 
    }
    for(let i = 0; i < nums.length; i++){
        for(let j = i + 1; j <= nums.length; j++){
            if(presum[j] - presum[i] === k){
                ans++;
            }
        }
    }
    return ans;
};