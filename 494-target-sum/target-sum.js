/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function (nums, target) {
    const n = nums.length;
    let map = new Map();
    map.set(0, 1);

    for (let i = 0; i < n; i++) {
        let next_map = new Map();
        for (let key of map.keys()) {
            let curSum = key + nums[i];
            let curSum2 = key - nums[i];
            let ways = map.get(key)

            next_map.set(curSum, next_map.has(curSum) ? next_map.get(curSum) + ways : ways)
            next_map.set(curSum2, next_map.has(curSum2) ? next_map.get(curSum2) + ways : ways)
        }
        map = next_map;
    }
    return map.has(target) ? map.get(target) : 0;
};