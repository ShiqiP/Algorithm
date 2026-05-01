/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = new Map();
    let ans = new Array(2);
    for(let i = 0; i < nums.length; i++){
        let aim = target - nums[i];
        if(map.has(aim)){
            ans[0] = i;
            ans[1] = map.get(aim);
        }else{
            map.set(nums[i], i)
        }
    }
    return ans;
};