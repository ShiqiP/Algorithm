/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function (nums, target) {
    // combination 
    const n = nums.length;
    // let preSum = [0];
    let map = new Map();
    map.set(0, 1);

    for (let i = 0; i < n; i++) {
        let next_map = new Map();
        for (let key of map.keys()) {
            let curSum = key + nums[i];
            let curSum2 = key - nums[i];
            let ways = map.get(key)
            if (next_map.has(curSum)) {
                next_map.set(curSum, next_map.get(curSum) + ways)
            } else {
                next_map.set(curSum, ways)
            }
            if (next_map.has(curSum2)) {
                next_map.set(curSum2, next_map.get(curSum2) + ways)
            } else {
                next_map.set(curSum2, ways)
            }
            // for (let el of curNum) {
            //     let num = el + preSum[j];
            //     curSum.push(num);
            //     if (i === n - 1) {
            //         if (num === target) {
            //             ans++;
            //         }
            //     }
            // }
        }
        map = next_map;
    }
    console.log(map)
    return map.has(target) ? map.get(target) : 0;
};