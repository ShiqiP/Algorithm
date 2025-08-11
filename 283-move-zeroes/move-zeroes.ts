/**
 Do not return anything, modify nums in-place instead.
 */
// nums = [0,1,0,3,12]
// 1,3,0,0,12
// 1 3 12,
function moveZeroes(nums: number[]): void {
    let p1 = 0;
    for (let p2 = 0; p2 < nums.length; p2++) {
        if (nums[p1] === 0 && nums[p2] !== 0) {
            nums[p1] = nums[p2];
            nums[p2] = 0;
            p1++;
        }
        if (nums[p1] !== 0) p1++;
    }
};