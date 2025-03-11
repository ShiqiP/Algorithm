/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let ans = [];
    let map = new Map();
    for(let i = 0; i < nums.length; i++){
        let indexArray = map.has(nums[i]) ? map.get(nums[i]) : [];
        map.set(nums[i], [...indexArray, i]);
    }
    for(let value of map.keys()){
        const curIndices = map.get(value);
        const curIndex = curIndices.shift(); 
        const diff = target - value;
        if(map.has(diff) && map.get(diff) > 0){
            const diffIndices = map.get(diff)
            ans = [curIndex, diffIndices.shift()];
            return ans;
        }
        curIndices.unshift(curIndex);
    }
    return ans;
};