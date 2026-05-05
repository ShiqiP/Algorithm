function threeSum(nums: number[]): number[][] {
    // 1. sort the array
    nums.sort((a,b) => a - b); // ascending order
    let ans: number[][] = [];
    // 2. for i skip if the current value === previous.
    for (let i = 0; i < nums.length && nums[i] <= 0; i++) {
        // (prevent duplicate value of index i)
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        twoSum(i, ans, nums);
    }
    function twoSum(i, ans, nums) {
        // two pointer
        let left = i + 1, right = nums.length - 1;
        while(left < right){
            let complement = nums[left] + nums[right] + nums[i];
            if(complement === 0){
                ans.push([nums[left++], nums[right--], nums[i]]);
                while(left < right && nums[left] === nums[left - 1]){
                    left++;
                }
            }else if(complement > 0){
                    right--;
            }else if(complement < 0){
                    left++;
            }
        }
        // // hashMap
        // let map = new Set();
        // for (let j = i + 1; j < nums.length; j++) {
        //     const complement = -nums[i] - nums[j];
        //     if (map.has(complement)) {
        //         ans.push([complement, nums[i], nums[j]]);
        //         // 3. for j current === next
        //         // prevent duplicate value of index j
        //         while (j + 1 < nums.length && nums[j] === nums[j + 1]) {
        //             j++;
        //         }
        //     }
        //     map.add(nums[j]);
        // }
    }
    return ans;
};