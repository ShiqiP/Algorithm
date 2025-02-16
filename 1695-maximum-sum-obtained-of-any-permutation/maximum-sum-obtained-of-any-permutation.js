/**
 * @param {number[]} nums
 * @param {number[][]} requests
 * @return {number}
 */
var maxSumRangeQuery = function(nums, requests) {
    const n = nums.length;
    let arr = new Array(nums.length).fill(0);
    for(let req of requests){
        arr[req[0]] += 1;
        if(req[1] + 1 < nums.length){
            arr[req[1] + 1] -= 1;
        }
    }
    let overlaps = 0;
    for(let i = 0; i < n; i++){
        overlaps += arr[i];
        arr[i] = overlaps
    }
    let ans = 0;
    arr.sort((a,b) => b - a);
    nums.sort((a,b) => b - a);
    for(let i = 0; i < n; i++){
        if(arr[i] <= 0) continue;
        ans += arr[i] * nums[i];
    }
    return ans%(Math.pow(10,9) + 7);
};