function twoSum(nums: number[], target: number): number[] {
    let map = new Map();
    let ans = [];
    for(let i = 0; i < nums.length; i++){
        if(map.has(target - nums[i])){
            ans.push(i);
            ans.push(map.get(target - nums[i]))
        }else{
            map.set(nums[i], i);
        }
    }
    return ans;
};