function subarraySum(nums: number[], k: number): number {
    // pre sum 
    // interate the presum
    let presum: number[] = [];
    presum[0] = 0
    for (let i = 1; i <= nums.length; i++) {
        presum[i] = presum[i - 1] + nums[i - 1];
    }
    console.log(presum)
    let i = 0, ans = 0;
    while (i < nums.length) {
        let j = i + 1;
        while (j <= nums.length) {
            if (presum[j] - presum[i] === k) ans++;
            j++;
        }
        i++
    }

    // [1, 3, 6]
    // sum  j  i  ans
    // 1    0  0  0
    // 3    0  1  1
    // 6,5,3   0,1,2   2 
    return ans;
};