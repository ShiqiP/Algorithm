function trap(height: number[]): number {
    // brute force solution
    // left el right 
    const n = height.length;
    let ans = 0;
    // Math.min(left, right) - height[i]
    // 1. iterate height
    // need to be in the middle to store water
    // 2. DP to store the leftmax and rightmax of each position with O(2N);
    let rightMax = new Array(n).fill(0);
    let leftMax = new Array(n).fill(0);
    leftMax[0] = height[0];
    for (let i = 1; i < n; i++) {
        leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }
    rightMax[n - 1] = height[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }
    for (let i = 1; i < n; i++) {
        // let leftMax = 0, rightMax = 0;
        // find the leftMax, rightMax
        // for (let j = i; j >= 0; j--) {
        //     leftMax = Math.max(height[j], leftMax);
        // }
        // for (let k = i; k < n; k++) {
        //     rightMax = Math.max(height[k], rightMax);
        // }
        // calculate the water of each position
        // only store the water of the minimum height
        ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return ans;
}