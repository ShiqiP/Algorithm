/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    // Brute Force
    // for(let i = 0; i < nums.length - 1; i++){
    //     for(let j = i + 1; j < nums.length; j++){
    //         if(nums[i] + nums[j] === target){
    //             return [i, j];
    //         }
    //     }
    // }

    // Hash
    let map = new Map();
    for(let i = 0; i < nums.length; i++){
        if(map.has(target - nums[i])){
            return [map.get(target - nums[i]), i];
        }else{
            map.set(nums[i], i);
        }
    }
};