/**
 * @param {number[]} nums
 * @param {number} key
 * @param {number} k
 * @return {number[]}
 */
var findKDistantIndices = function (nums, key, k) {

    // result should be an array of indices 
    // constraints should be 
    // abs(i - j) <= k

    // fist step is to find the indices where nums[j] = key
    // traverse it O(n) j array [2,5]
    // second k = 1  [1,2,3] [4,5,6] O(n)

    //[0,1,2,3,4] min 0 max len - 1
    // (-2,2) (-1,4) 2n
    let jArray = [];
    for (let i in nums) {
        if (nums[i] == key) {
            jArray.push(+i)
        }
    }
    let ans = []; // 
    let last = 0;// 
    for (const n of jArray) {
        if (last > nums.length - 1) break;
        // (-4, 6)
        const min = Math.max(last, n - k); // 0
        const max = Math.min(nums.length - 1, n + k); //6
        for (let i = min; i <= max; i++) {
            ans.push(i);
        }
        last = max + 1;
    }
    return ans;
};