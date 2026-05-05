function threeSum(nums: number[]): number[][] {
    // 1. sort the array
    nums.sort(); // ascending order
    let ans: number[][] = [];
    // 2. for i skip if the current value === previous.
    for (let i = 0; i < nums.length && nums[i] <= 0; i++) {
        // (prevent duplicate value of index i)
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        let map = new Set();
        for (let j = i + 1; j < nums.length; j++) {
            const complement = -nums[i] - nums[j];
            if (map.has(complement)) {
                ans.push([complement, nums[i], nums[j]]);
                // 3. for j current === next
                // prevent duplicate value of index j
                while (j + 1 < nums.length && nums[j] === nums[j + 1]) {
                    j++;
                }
            }
            map.add(nums[j]);
        }
    }
    return ans;
};